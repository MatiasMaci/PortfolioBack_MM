/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Projects;
import com.MM.PortBackend.repository.InterProjectsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectService {
    
    @Autowired
    private InterProjectsRepository IProRepo;
    
    public List<Projects> list(){
        return IProRepo.findAll();
    }
    
    public Optional<Projects> getOne(int id){
        return IProRepo.findById(id);
    }
    
    public Optional<Projects> findByNombreProject(String nombreProject){
        return IProRepo.findByNombreProject(nombreProject);
    }
    
    public void save(Projects Proj){
        IProRepo.save(Proj);
    }
    
    public void delete(int id){
        IProRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return IProRepo.existsById(id);
    }
    
    public boolean existsByNombreProject(String nombreProject){
        return IProRepo.existsByNombreProject(nombreProject);
    }
    
}
