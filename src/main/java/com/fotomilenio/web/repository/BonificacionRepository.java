package com.fotomilenio.web.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fotomilenio.web.entity.Bonificacion;
import com.fotomilenio.web.entity.Empleado;

public interface  BonificacionRepository extends JpaRepository<Bonificacion, Long>{

    /*
    @Query("SELECT h FROM HorasExtra h WHERE h.empleado = :empleado AND h.fecha = :fecha")
    List<Bonificacion> findByEmpleadoAndFecha(@Param("empleado") Empleado empleado, @Param("fecha") LocalDate fecha);
 */
    }
