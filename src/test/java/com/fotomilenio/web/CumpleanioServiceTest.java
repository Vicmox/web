package com.fotomilenio.web;

import static org.mockito.Mockito.*;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.repository.EmpleadoRepository;
import com.fotomilenio.web.service.CumpleanioService;
import com.fotomilenio.web.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CumpleanioServiceTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private CumpleanioService cumpleanioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testEnviarFelicitacionCumpleanios() {

        // Crear datos de prueba
        LocalDate today = LocalDate.now();

        //Crear los empleados
        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Victor Monsalvo");
        empleado1.setEmail("vicmo.v2@gmail.com");
        empleado1.setFechaCumpleanos(LocalDate.of(1990, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));

        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Manuel Suarez");
        empleado2.setEmail("victormanuelms@ufps.edu.co");
        empleado2.setFechaCumpleanos(today);

        //Listo los empleados 
        List<Empleado> empleados = Arrays.asList(empleado1, empleado2);

        // Configurar comportamiento del repositorio simulado
        when(empleadoRepository.findByBirthday(LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth())).thenReturn(empleados);

        // Ejecutar el método a probar
        cumpleanioService.enviarFelicitacionCumpleanios();

        // Verificar que se enviaron los correos de felicitación
        verify(emailService, times(1)).sendBirthdayGreetings("vicmo.v2@gmail.com", "Victor Monsalvo");
        verify(emailService, times(1)).sendBirthdayGreetings("victormanuelms@ufps.edu.co", "Manuel Suarez");
    }
}
