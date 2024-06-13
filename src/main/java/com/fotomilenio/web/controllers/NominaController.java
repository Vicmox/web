package com.fotomilenio.web.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.service.NominaService;

@RestController
public class NominaController {

    @Autowired
    private NominaService nominaService;

    @GetMapping("/calcularSalario")
    public double calcularSalario(@RequestParam Empleado empleado, @RequestParam LocalDate fecha) {
        return nominaService.calcularSalario(empleado, fecha);
    }
    
}
