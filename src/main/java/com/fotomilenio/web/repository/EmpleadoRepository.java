package com.fotomilenio.web.repository;

import com.fotomilenio.web.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query("SELECT e FROM Empleado e WHERE MONTH(e.fechaCumpleanios) = :month AND DAY(e.fechaCumpleanios) = :day")
    List<Empleado> findByBirthday(@Param("month") int month, @Param("day") int dayOfMonth);


    
}
