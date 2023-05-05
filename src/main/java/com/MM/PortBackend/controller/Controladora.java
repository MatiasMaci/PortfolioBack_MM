package com.MM.PortBackend.controller;

import com.MM.PortBackend.model.Persona;
import com.MM.PortBackend.service.InterPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controladora {
    
    @Autowired
    public InterPersonaService IPersServ;
    
    @GetMapping("/traer/personas")
    @ResponseBody
    public List<Persona> devolverPersona(){
        return IPersServ.getPersonas();
    }

    
    @PostMapping("/crear/persona")
    public String crearPersona(@RequestBody Persona pers){
        IPersServ.savePersona(pers);
        return "Producto creado correctamente";
    }
 
    
    @DeleteMapping("/eliminar/persona/{id}")
    public String eliminarPersona(Long id){
        IPersServ.deletePersona(id);
        return "Producto eliminado correctamente";
    }
    
    @GetMapping("/buscar/persona/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return IPersServ.findPersona(id);
    }

    
    @PutMapping("/editar/persona/{id}")
    public String modificarProducto(@PathVariable Long id,@RequestBody Persona pers){
        pers.setId(id);
        IPersServ.savePersona(pers);
        return "Producto modificado exitosamente";
    }
}
