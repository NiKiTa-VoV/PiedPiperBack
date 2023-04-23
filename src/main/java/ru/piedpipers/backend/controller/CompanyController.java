package ru.piedpipers.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.piedpipers.backend.database.model.base.User;
import ru.piedpipers.backend.database.model.entity.Company;
import ru.piedpipers.backend.database.repository.realisation.CompanyRepository;
import ru.piedpipers.backend.database.repository.realisation.UserRepository;
import ru.piedpipers.backend.security.data.CurrentUser;
import ru.piedpipers.backend.security.data.UserPrincipal;
import ru.piedpipers.backend.general.message.realization.misc.InnParseResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/company")
@RequiredArgsConstructor
@Transactional
public class CompanyController {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;


    @PostMapping("/me")
    public void updateCompany(@CurrentUser UserPrincipal principal, @Valid @RequestBody Company company) {
        User user = userRepository.findById(principal.getId()).get();

        company = companyRepository.save(company);
        user.setCompany(company);
    }

    @GetMapping("/parse/{inn}")
    public ResponseEntity<InnParseResponse> parseByInn(@PathVariable("inn") String inn) throws JsonProcessingException {
        String urlInn = "https://www.rusprofile.ru/ajax.php?query=" + inn + "&action=search&cacheKey=0.9669255018074794";

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(urlInn, String.class);

        ObjectMapper mapper = new ObjectMapper();
        String id;
        try {
            Map<String, Object> personMap = mapper.readValue(json, Map.class);
            if (personMap.get("ul_count").equals(0)) {
                return ResponseEntity.notFound().build();
            }

            id = (String) ((Map) ((List) personMap.get("ul")).get(0)).get("aci_id");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        String url = "https://www.rusprofile.ru/id/" + id;

        String title = "";

        String ogrn = "";
        String ogrnDate = "";

        String kpp = "";

        String address = "";

        String dateReg = "";

        String capital = "";

        String contactPost = "";
        String contactName = "";
        String contactDate = "";

        boolean status = false;

        boolean reliable = false;
        String courtCases = "0";
        String debt = "0";


        try {
            Document doc = Jsoup.connect(url).get();

            Elements selectTitle = doc.select("div.company-header__row");
            for (Element el : selectTitle) {
                title = el.text();
            }

            Elements selectOgrn = doc.select("dt:contains(ОГРН)");
            for (Element el : selectOgrn) {
                ogrn = ((Element) el.nextElementSibling().childNode(1)).text();
                ogrnDate = el.nextElementSibling().nextElementSibling().text();
            }

            Elements selectInnKpp = doc.select("dt:contains(ИНН/КПП)");
            for (Element el : selectInnKpp) {
                kpp = el.nextElementSibling().nextElementSibling().text();
            }

            address = doc.getElementById("clip_address").text();

            Elements selectDate = doc.select("dt:contains(Дата регистрации)");
            for (Element el : selectDate) {
                dateReg = el.nextElementSibling().text();
            }

            Elements selectCapital = doc.select("dt:contains(Уставный капитал)");
            for (Element el : selectCapital) {
                capital = el.nextElementSibling().text();
            }


            Elements selectContact = doc.select("span.company-info__title:contains(Руководитель)");
            for (Element el : selectContact) {
                el = el.nextElementSibling();
                contactPost = el.text();
                el = el.nextElementSibling();
                contactName = el.text();
                el = el.nextElementSibling();
                contactDate = el.text();
            }

            status = doc.select("div.company-status:contains(Действующая организация)").size() > 0;

            reliable = doc.select("a.rely-rating-positive:contains(Высокая)").size() > 0;
            for (Element element : doc.select("a.gtm_ar_1")) {
                courtCases = element.text();
            }

            for (Element element : doc.select("a.gtm_fs_all")) {
                debt = element.text();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        InnParseResponse parseResponse = new InnParseResponse(
                title,
                ogrn,
                ogrnDate,
                dateReg,
                inn,
                kpp,
                address,
                contactPost + " " + contactName + " " + contactDate,
                capital,
                status,
                reliable,
                courtCases,
                debt
        );

        return ResponseEntity.ok(parseResponse);
    }
}
