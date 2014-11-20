package com.jeenguyen.demo.oauth.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jeebb on 20/11/2014.
 */
@Controller
@RequestMapping("/")
public class AuthController {

    public static final String LOGIN_PAGE = "login";

    @RequestMapping(value = "login",
                    method = RequestMethod.GET)
    public String login() {
        return LOGIN_PAGE;
    }

    @RequestMapping(value = "testRedirect",
                    method = RequestMethod.GET)
    @ResponseBody
    public String testRedirect() {
        return "Green codes !!!";
    }

}
