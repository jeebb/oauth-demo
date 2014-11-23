package com.jeenguyen.demo.web.controller;

import com.jeenguyen.demo.web.model.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jeebb on 21/11/2014.
 */
@Controller
@RequestMapping("/")
public class WebController {

    public static final String LOGIN = "login";
    public static final String APP = "app";

    @Value("${oauth.auth.url}")
    private String authUrl;

    @Value("${oauth.token.url}")
    private String accessTokenUrl;

    @Value("${oauth.id.secret}")
    private String encodedIdSecret;

    @Value("${oauth.token.expire}")
    private Integer accessTokenExpireTime;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    public String index(Model model,
                        @RequestParam(value = "code", required = false) String authCode,
                        HttpServletRequest request, HttpServletResponse response) {
        String page = APP;
        if (authCode != null && authCode.trim().length() > 0) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Basic ".concat(encodedIdSecret));
            ResponseEntity<AccessTokenResponse> accessTokenResponse = restTemplate.
                    exchange(String.format(accessTokenUrl, authCode), HttpMethod.GET,
                            new HttpEntity<Object>(httpHeaders), AccessTokenResponse.class);
            if (accessTokenResponse.getStatusCode() == HttpStatus.ACCEPTED ||
                    accessTokenResponse.getStatusCode() == HttpStatus.OK) {
                Cookie cookie = new Cookie("access_token", accessTokenResponse.getBody().getAccessToken());
                cookie.setMaxAge(accessTokenExpireTime);
                response.addCookie(cookie);
            } else {
                model.addAttribute("authUrl", authUrl);
                page = LOGIN;
            }
        } else {
            model.addAttribute("authUrl", authUrl);
            page = LOGIN;
        }
        return page;
    }

}
