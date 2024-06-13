package com.fotomilenio.web.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fotomilenio.web.service.CumpleanioService;


@Component
public class TareasProgramadas {

    @Autowired
    private CumpleanioService cumpleanioService;

    @Scheduled(cron = "0 0 8 * * *") // Se ejecuta todos los días a las 8:00 AM
    public void enviarFelicitacionCumpleanios() {
        cumpleanioService.enviarFelicitacionCumpleanios();
    }
}


    

