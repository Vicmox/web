package com.fotomilenio.web.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.fotomilenio.web.entity.Deduccion;
import com.fotomilenio.web.entity.Empleado;


@Repository
public interface  DeduccionRepository extends JpaRepository<Deduccion, Long>{

    /*     @Query("SELECT h FROM HorasExtra h WHERE h.empleado = :empleado AND h.fecha = :fecha")
    List<Deduccion> findByEmpleadoAndFecha(@Param("empleado") Empleado empleado, @Param("fecha") LocalDate fecha);
*/
    }