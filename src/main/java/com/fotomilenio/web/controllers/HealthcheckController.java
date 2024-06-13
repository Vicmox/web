package com.fotomilenio.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {
    
    @RequestMapping("/healtcheck")
    public String Status(){
        return "Estado activo";
    }
}
