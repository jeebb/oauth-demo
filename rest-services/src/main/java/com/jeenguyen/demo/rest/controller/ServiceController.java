package com.jeenguyen.demo.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

/**
 * Created by jeebb on 20/11/2014.
 */
@RestController
@RequestMapping("/services")
public class ServiceController {

    @RequestMapping(value = "random")
    public Integer random() {
        return new SecureRandom().nextInt();
    }

}
