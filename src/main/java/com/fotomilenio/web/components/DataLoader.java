package com.fotomilenio.web.components;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.repository.EmpleadoRepository;
import com.fotomilenio.web.service.EmpleadoService;

@Component
public class DataLoader implements CommandLineRunner{

    private final EmpleadoService empleadoService;

    public DataLoader(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public void run(String... args) throws Exception {

        // Lógica para crear empleados de prueba
        Empleado empleado1 = new Empleado("Nombre1", "email1@example.com", "32", LocalDate.of(1990, 1, 1));
        Empleado empleado2 = new Empleado("Nombre2", "email2@example.com", "21",LocalDate.of(2001, 3, 21));

        empleadoService.saveAllEmpleados(Arrays.asList(empleado1, empleado2));
    }
}
