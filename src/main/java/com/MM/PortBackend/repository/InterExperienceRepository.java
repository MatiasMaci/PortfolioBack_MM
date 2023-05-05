/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MM.PortBackend.repository;

import com.MM.PortBackend.model.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterExperienceRepository extends JpaRepository<Experience, Integer>{
    public Optional<Experience> findByNombreEmpresa(String nombreEmpresa);
    public boolean existsByNombreEmpresa(String nombreEmpresa);
}
