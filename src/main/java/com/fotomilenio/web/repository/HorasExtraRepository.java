package com.fotomilenio.web.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fotomilenio.web.entity.Empleado;
import com.fotomilenio.web.entity.HorasExtra;

@Repository
public interface  HorasExtraRepository extends JpaRepository<HorasExtra, Long>{
    
    /* 
    @Query("SELECT h FROM HorasExtra h WHERE h.empleado = :empleado AND h.fecha = :fecha")
    List<HorasExtra> findByEmpleadoAndFecha(@Param("empleado") Empleado empleado, @Param("fecha") LocalDate fecha);
*/
    }
