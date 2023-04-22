package ru.skzmk.backend.general.data.handler.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.skzmk.backend.general.message.model.responsemessage.ResponseMessageFactory;
import ru.skzmk.backend.general.message.model.wrapper.MessageWrapper;
import ru.skzmk.backend.general.message.service.ResponseConverterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Service
public class AuthRegistrationService {

    public static String PARAMETER_REGISTRATION = "reg";
    public static String PARAMETER_REGISTRATION_COOKIE = "user_reg";
    public static String PARAMETER_NAME = "name";
    public static String PARAMETER_NAME_COOKIE = "user_name";
    public static String PARAMETER_SURNAME = "surname";
    public static String PARAMETER_SURNAME_COOKIE = "user_surname";
    public static String PARAMETER_PATRONYMIC = "patronymic";
    public static String PARAMETER_PATRONYMIC_COOKIE = "user_patronymic";

    private final ResponseConverterService responseConverterService;

    public boolean registrationOAuth2(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }

    public boolean validationRegistrationOAuth2(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter(PARAMETER_NAME).trim();
        String surname = request.getParameter(PARAMETER_NAME).trim();

        return checkParameter(response, name, "name", "entity.registration.name")
                && checkParameter(response, surname, "surname", "entity.registration.surname");
    }

    public boolean checkParameter(HttpServletResponse response, String param, String paramName, String langParamName) {
        if (StringUtils.hasText(param)) return true;

        MessageWrapper.create(null,
                ResponseMessageFactory.createMessageFieldLocalized(paramName,
                        langParamName,
                        "message.warn.field.empty"));

//        responseConverterService.writeMessageWrapperInResponseParamAndRedirect();

//        RedirectUrl
        return false;
    }

    public boolean isRegistrationRequest(HttpServletRequest request) {
        String reg = request.getParameter(PARAMETER_REGISTRATION);
        if (StringUtils.hasText(reg)) {
            try {
                return Boolean.parseBoolean(reg);
            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }
}
