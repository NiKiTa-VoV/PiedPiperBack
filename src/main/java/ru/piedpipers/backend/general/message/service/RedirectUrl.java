package ru.piedpipers.backend.general.message.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.piedpipers.backend.security.service.HttpCookieAuthorizationRequestRepository;
import ru.piedpipers.backend.util.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class RedirectUrl {

    private final String redirectUrl;
    private final Map<String, String> params = new HashMap<>();

    public RedirectUrl(HttpServletRequest request, ObjectMapper jsonConverter) {
        redirectUrl = CookieUtils.getCookie(request, HttpCookieAuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue)
                .orElse(("/"));


    }

    public RedirectUrl addParam(Object param, boolean toJson) {
        return null;
    }
}
