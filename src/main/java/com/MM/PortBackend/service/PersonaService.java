package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Persona;
import com.MM.PortBackend.repository.InterPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService{

    @Autowired
    private InterPersonaRepository IPersRepo;
    
    public List<Persona> list(){
        return IPersRepo.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return IPersRepo.findById(id);
    }
    
    public Optional<Persona> findByNombre(String nombre){
        return IPersRepo.findByNombre(nombre);
    }
    
    public void save(Persona pers){
        IPersRepo.save(pers);
    }
    
    public void delete(int id){
        IPersRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return IPersRepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return IPersRepo.existsByNombre(nombre);
    }
}
