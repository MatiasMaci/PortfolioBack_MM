/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MM.PortBackend.repository;

import com.MM.PortBackend.model.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterProjectsRepository extends JpaRepository<Projects,Integer>{
    public Optional<Projects> findByNombreProject(String nombreProject);
    public boolean existsByNombreProject(String nombreProject);
}
