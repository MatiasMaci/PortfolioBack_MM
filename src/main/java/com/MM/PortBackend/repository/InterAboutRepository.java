package com.MM.PortBackend.repository;

import com.MM.PortBackend.model.AboutMe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterAboutRepository extends JpaRepository<AboutMe, Integer>{
    
}
