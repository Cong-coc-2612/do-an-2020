package com.laptrinhjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userController{

	@RequestMapping("/")
    public String welcome() {
        return "index";
    }
}
