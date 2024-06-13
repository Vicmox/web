package com.fotomilenio.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    //Listar todos los empleados 
    @GetMapping
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        model.addAttribute("empleados", empleados);
        return "listado-empleados"; // Nombre de la vista Thymeleaf
    }

    //Listar un unico empleado x ID 
    @GetMapping("/{id}")
    public String obtenerEmpleadoPorId(@PathVariable("id") Long id, Model model) {
        Empleado empleado = empleadoService.getEmpleadoById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + id));
        model.addAttribute("empleado", empleado);
        return "detalle-empleado"; // Nombre de la vista Thymeleaf
    }

    //Controller de la vista de agregar empleado
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "agregar-empleado"; // Nombre de la vista Thymeleaf
    }

    //Guardar un empleado
    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@Validated @ModelAttribute("empleado") Empleado empleado, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Aquí puedes manejar los errores de validación, por ejemplo, regresar al formulario con los errores
            return "formulario-empleado";
        }

        // Lógica para guardar el empleado en la base de datos
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados"; // Redirigir a la lista de empleados después de guardar
    }

    //Controller vista formulario editar
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Empleado empleado = empleadoService.getEmpleadoById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + id));
        model.addAttribute("empleado", empleado);
        return "formulario-empleado"; // Nombre de la vista Thymeleaf
    }

    //Elminar un empleado
    @DeleteMapping("/{id}/eliminar")
    public String eliminarEmpleado(@PathVariable("id") Long id) {
        empleadoService.deleteEmpleado(id);
        return "redirect:/empleados"; // Redirige a la lista de empleados
    }
}
