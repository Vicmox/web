package com.fotomilenio.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpeladoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    // Listar todos los empleados
    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    // Crear un nuevo empleado
    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    // Actualizar un empleado existente
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetalles) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }
        empleado.setNombre(empleadoDetalles.getNombre());
        empleado.setEmail(empleadoDetalles.getEmail());
        // Actualiza otros campos según sea necesario

        Empleado empleadoActualizado = empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    // Eliminar un empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }
        empleadoService.deleteEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
