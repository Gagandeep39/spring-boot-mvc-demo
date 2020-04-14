package com.cg.springbootmvcemployeelab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gagandeep
 * @date 14-04-2020
 * @time 12:39
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String start(){
        return "index";
    }
}
