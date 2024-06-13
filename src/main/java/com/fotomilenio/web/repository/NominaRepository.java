package com.fotomilenio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fotomilenio.web.entity.Nomina;

@Repository
public interface  NominaRepository extends JpaRepository<Nomina, Long>{
    
}
