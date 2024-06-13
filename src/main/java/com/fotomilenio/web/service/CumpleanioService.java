package com.fotomilenio.web.service;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CumpleanioService {
    
        @Autowired
        private EmailService emailService;
    
        @Autowired
        private EmpleadoRepository empleadoRepository;
    
        public void enviarFelicitacionCumpleanios() {
            // Obtener todos los empleados cuyo cumpleaños sea hoy
            LocalDate today = LocalDate.now();
            int currentMonth = today.getMonthValue();
            int currentDayOfMonth = today.getDayOfMonth();
    
            List <Empleado> empleados = empleadoRepository.findByBirthday(currentMonth, currentDayOfMonth);
    
            for (Empleado empleado : empleados) {
                // Verificar si la fecha de cumpleaños coincide con la fecha actual
                if (empleado.getFechaCumpleanios().getMonth() == today.getMonth() &&
                    empleado.getFechaCumpleanios().getDayOfMonth() == today.getDayOfMonth()) {
                    
                    // Enviar felicitación por correo electrónico
                    emailService.sendBirthdayGreetings(empleado.getEmail(), empleado.getNombre());;
                }
            }
        }
    }




