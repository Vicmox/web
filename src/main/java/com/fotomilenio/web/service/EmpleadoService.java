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

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado updateEmpleado(Long id, Empleado empleado) {
        Empleado existingEmpleado = empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        existingEmpleado.setNombre(empleado.getNombre());
        existingEmpleado.setEmail(empleado.getEmail());
        return empleadoRepository.save(existingEmpleado);
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }
}
