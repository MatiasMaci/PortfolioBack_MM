/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Education;
import com.MM.PortBackend.repository.InterEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService {
    
    @Autowired
    private InterEducationRepository IEduRepo;
    
    public List<Education> list(){
        return IEduRepo.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return IEduRepo.findById(id);
    }
    
    public Optional<Education> findByNombreCurso(String nombreCurso){
        return IEduRepo.findByNombreCurso(nombreCurso);
    }
    
    public void save(Education Edu){
        IEduRepo.save(Edu);
    }
    
    public void delete(int id){
        IEduRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return IEduRepo.existsById(id);
    }
    
    public boolean existsByNombreCurso(String nombreCurso){
        return IEduRepo.existsByNombreCurso(nombreCurso);
    }
    
}
