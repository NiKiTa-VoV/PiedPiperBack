package ru.skzmk.backend.general.message.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.skzmk.backend.util.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static ru.skzmk.backend.security.service.HttpCookieAuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

public class RedirectUrl {

    private final String redirectUrl;
    private final Map<String, String> params = new HashMap<>();

    public RedirectUrl(HttpServletRequest request, ObjectMapper jsonConverter) {
        redirectUrl = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue)
                .orElse(("/"));


    }

    public RedirectUrl addParam(Object param, boolean toJson) {
        return null;
    }
}
