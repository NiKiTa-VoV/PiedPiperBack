package ru.skzmk.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class ApiMain {
    public static void main(String[] args) throws JsonProcessingException {

        String urlInn = "https://www.rusprofile.ru/ajax.php?query=" + 4825071673L + "&action=search&cacheKey=0.9669255018074794";

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(urlInn, String.class);

        ObjectMapper mapper = new ObjectMapper();
        String id;
        try {
            Map<String, Object> personMap = mapper.readValue(json, Map.class);
            if (personMap.get("ul_count").equals(0)) {
                return;
            }

            id = (String) ((Map) ((List) personMap.get("ul")).get(0)).get("aci_id");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


        String url = "https://www.rusprofile.ru/id/" + id;

        String title = "";

        String ogrn = "";
        String ogrn_date = "";

        String inn = "";
        String kpp = "";

        String address = "";

        String date_reg = "";

        String capital = "";

        String contactPost = "";
        String contactName = "";
        String contactDate = "";


        try {
            Document doc = Jsoup.connect(url).get();

            Elements selectTitle = doc.select("div.company-header__row");
            for (Element el : selectTitle) {
                title = el.text();
            }

            Elements selectOgrn = doc.select("dt:contains(ОГРН)");
            for (Element el : selectOgrn) {
                ogrn = ((Element) el.nextElementSibling().childNode(1)).text();
                ogrn_date = el.nextElementSibling().nextElementSibling().text();
            }

            Elements selectInnKpp = doc.select("dt:contains(ИНН/КПП)");
            for (Element el : selectInnKpp) {
                inn = el.nextElementSibling().text();
                kpp = el.nextElementSibling().nextElementSibling().text();
            }

            address = doc.getElementById("clip_address").text();

            Elements selectDate = doc.select("dt:contains(Дата регистрации)");
            for (Element el : selectDate) {
                date_reg = el.nextElementSibling().text();
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

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
