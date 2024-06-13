package com.fotomilenio.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpeladoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        model.addAttribute("empleados", empleados);
        return "listado-empleados";
    }

    @PostMapping
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleados";
    }

    @PostMapping("/{id}")
    public String actualizarEmpleado(@PathVariable Long id, @ModelAttribute Empleado empleado) {
        empleadoService.updateEmpleado(id, empleado);
        return "redirect:/empleados";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoService.deleteEmpleado(id);
        return "redirect:/empleados";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Empleado obtenerEmpleadoPorId(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

 
}
