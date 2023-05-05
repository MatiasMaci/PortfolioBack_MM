package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Persona;
import com.MM.PortBackend.repository.InterPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements InterPersonaService{

    @Autowired
    private InterPersonaRepository IPersRepo;
    
    @Override
    public List<Persona> getPersonas() {
        return IPersRepo.findAll();
    }

    @Override
    public void savePersona(Persona pers) {
        IPersRepo.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        IPersRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return IPersRepo.findById(id).orElse(null);
    }
    
}
