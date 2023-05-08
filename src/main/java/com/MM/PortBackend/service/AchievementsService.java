/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Achievements;
import com.MM.PortBackend.repository.InterAchievementsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AchievementsService {
    
    @Autowired
    private InterAchievementsRepository IAchiRep;
    
    public List<Achievements> list() {
        return IAchiRep.findAll();
    }
    
    public Optional<Achievements> getOne(int id){
        return IAchiRep.findById(id);
    }

    public void save(Achievements achievements) {
        IAchiRep.save(achievements);
    }

    public void delete(int id) {
        IAchiRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return IAchiRep.existsById(id);
    } 
}
