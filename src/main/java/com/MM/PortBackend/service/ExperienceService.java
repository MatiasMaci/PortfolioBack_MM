/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Experience;
import com.MM.PortBackend.repository.InterExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ExperienceService {
    
    @Autowired
    InterExperienceRepository IExpRepo;
    
    public List<Experience> list(){
        return IExpRepo.findAll();
    }
    
    public Optional<Experience> getOne(int id){
        return IExpRepo.findById(id);
    }
    
    public Optional<Experience> findByNombreEmpresa(String nombreEmpresa){
        return IExpRepo.findByNombreEmpresa(nombreEmpresa);
    }
    
    public void save(Experience exp){
        IExpRepo.save(exp);
    }
    
    public void delete(int id){
        IExpRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return IExpRepo.existsById(id);
    }
    
    public boolean existsByNombreEmpresa(String nombreEmpresa){
        return IExpRepo.existsByNombreEmpresa(nombreEmpresa);
    }
}
