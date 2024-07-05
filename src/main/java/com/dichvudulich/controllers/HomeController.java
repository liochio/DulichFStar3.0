package com.dichvudulich.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class HomeController {

    private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

    @GetMapping(value = "/index")
    public String index(Model model) {
        LOGGER.info("*************************** index");

        return "index";
    }


	//ctrl + alt + L : format code
	//ctrl + alt + O : bo import thua
	//ctrl + shift + F: tìm kiem key trong source
	//ctrl + shift + N: tìm kiem file
	//ctrl + shift + R: thay the trong source
	//ctrl + R: replace trong file
	//ctrl + F: tìm kiêm trong file
}
