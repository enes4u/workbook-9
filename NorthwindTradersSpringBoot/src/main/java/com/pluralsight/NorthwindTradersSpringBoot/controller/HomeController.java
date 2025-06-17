package com.pluralsight.NorthwindTradersSpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    //Application Programming Interface

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue="World!") String name) {
        return "Hello " + name;
    }
}