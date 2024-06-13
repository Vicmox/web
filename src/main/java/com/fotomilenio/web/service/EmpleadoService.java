package com.fotomilenio.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public List<Empleado> saveAllEmpleados(List<Empleado> empleado){

        return empleadoRepository.saveAll(empleado);
    }

    @Transactional
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    public Optional<Empleado> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}
