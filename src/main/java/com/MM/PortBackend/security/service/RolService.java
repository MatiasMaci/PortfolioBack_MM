/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.security.service;

import com.MM.PortBackend.security.entity.Rol;
import com.MM.PortBackend.security.enums.RolNombre;
import com.MM.PortBackend.security.repository.InterRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    public InterRolRepository IRolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return IRolRepo.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        IRolRepo.save(rol);
    }
    
    
    
}
