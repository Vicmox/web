package com.fotomilenio.web.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Empleado {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String edad;
    private LocalDate fechaCumpleanios;
    private double salarioBase;

    public Empleado(String nombre, String email, String edad, LocalDate fecha){
    
        this.nombre=nombre;
        this.email=email;
        this.edad=edad;
        this.fechaCumpleanios=fecha;

    }

    public Empleado(){

    }
}
