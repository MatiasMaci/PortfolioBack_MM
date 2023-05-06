/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Skills;
import com.MM.PortBackend.repository.InterSkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    
    @Autowired
    InterSkillsRepository ISkillRepo;
    
    public List<Skills> list(){
        return ISkillRepo.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return ISkillRepo.findById(id);
    }
    
    public Optional<Skills> findByNombreSkill(String nombreSkill){
        return ISkillRepo.findByNombreSkill(nombreSkill);
    }
    
    public void save(Skills skill){
        ISkillRepo.save(skill);
    }
    
    public void delete(int id){
        ISkillRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ISkillRepo.existsById(id);
    }
    
    public boolean existsByNombreSkill(String nombreSkill){
        return ISkillRepo.existsByNombreSkill(nombreSkill);
    }
}
