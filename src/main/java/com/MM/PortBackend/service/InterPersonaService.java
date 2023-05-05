package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Persona;
import java.util.List;


public interface InterPersonaService {
    //Trae todas las personas
    public List<Persona> getPersonas();
    //Guarda una persona
    public void savePersona(Persona pers);
    //Eliminamos persona
    public void deletePersona(Long id);
    //Trae una persona
    public Persona findPersona(Long id);
}
