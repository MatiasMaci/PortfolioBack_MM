/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MM.PortBackend.repository;

import com.MM.PortBackend.model.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InterEducationRepository extends JpaRepository<Education,Integer>{
    public Optional<Education> findByNombreCurso(String nombreCurso);
    public boolean existsByNombreCurso(String nombreCurso);
}
