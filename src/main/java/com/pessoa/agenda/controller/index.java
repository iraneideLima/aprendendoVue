package com.pessoa.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {

    @RequestMapping("/")
    public String PagIndex() {
        return "index_1";
    }

}
