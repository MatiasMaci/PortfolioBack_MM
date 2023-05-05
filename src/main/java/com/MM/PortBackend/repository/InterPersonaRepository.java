package com.MM.PortBackend.repository;

import com.MM.PortBackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterPersonaRepository extends JpaRepository<Persona, Long>{
    
}
