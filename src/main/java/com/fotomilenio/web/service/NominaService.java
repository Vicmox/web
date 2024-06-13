package com.fotomilenio.web.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fotomilenio.web.entity.Bonificacion;
import com.fotomilenio.web.entity.Deduccion;
import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.entity.HorasExtra;
import com.fotomilenio.web.entity.Nomina;
import com.fotomilenio.web.repository.BonificacionRepository;
import com.fotomilenio.web.repository.DeduccionRepository;
import com.fotomilenio.web.repository.EmpleadoRepository;
import com.fotomilenio.web.repository.HorasExtraRepository;
import com.fotomilenio.web.repository.NominaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class NominaService {
  
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private HorasExtraRepository horasExtraRepository;

    @Autowired
    private NominaRepository nominaRepository;

    @Autowired
    private BonificacionRepository bonificacionRepository;

    @Autowired
    private DeduccionRepository deduccionRepository;

    @Transactional
    public Nomina calcularNomina(Long empleadoId, LocalDate fechaPago) {
        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        List<HorasExtra> horasExtras = horasExtraRepository.findByEmpleadoAndFecha(empleado, fechaPago);
        List<Bonificacion> bonificaciones = bonificacionRepository.findByEmpleadoAndFecha(empleado, fechaPago);
        List<Deduccion> deducciones = deduccionRepository.findByEmpleadoAndFecha(empleado, fechaPago);

        double salarioTotal = empleado.getSalarioBase();

        for (HorasExtra horasExtra : horasExtras) {
            salarioTotal += (double) horasExtra.getCantidadHoras() * (double) horasExtra.getTarifaPorHora();
        }

        for (Bonificacion bonificacion : bonificaciones) {
            salarioTotal += bonificacion.getMonto();
        }

        for (Deduccion deduccion : deducciones) {
            salarioTotal -= deduccion.getMonto();
        }

        Nomina nomina = new Nomina();
        nomina.setEmpleado(empleado);
        nomina.setSalarioTotal(salarioTotal);
        nomina.setFechaPago(fechaPago);

        return nominaRepository.save(nomina);
    }

    public double calcularSalario(Empleado empleado, LocalDate fecha) {
        double salarioTotal = 0.0;
        List<HorasExtra> horasExtras = horasExtraRepository.findByEmpleadoAndFecha(empleado, fecha);

        for (HorasExtra horasExtra : horasExtras) {
            salarioTotal += (double) horasExtra.getCantidadHoras() * (double) horasExtra.getTarifaPorHora();
        }

        return salarioTotal;
    }
}
