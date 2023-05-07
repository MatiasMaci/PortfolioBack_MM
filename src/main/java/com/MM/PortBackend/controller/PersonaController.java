package com.MM.PortBackend.controller;

import com.MM.PortBackend.dto.DtoPersona;
import com.MM.PortBackend.model.Persona;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    public PersonaService PersServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = PersServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPers){
        if(StringUtils.isBlank(dtoPers.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(PersServ.existsByNombre(dtoPers.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Persona pers = new Persona(dtoPers.getNombre(),dtoPers.getApellido(), dtoPers.getImagen());
        PersServ.save(pers);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"),
                                                HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoPersona dtoPers){
        if(!PersServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(PersServ.existsByNombre(dtoPers.getNombre()) && 
                PersServ.findByNombre(dtoPers.getNombre())
                        .get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa persona ya existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPers.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Persona pers = PersServ.getOne(id).get();
        pers.setNombre(dtoPers.getNombre());
        pers.setApellido(dtoPers.getApellido());
        pers.setImagen(dtoPers.getImagen());
        
        PersServ.save(pers);
        return new ResponseEntity(new Mensaje("Persona actualizada"),
                                                HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!PersServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        PersServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Persona eliminada"),
                                                HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!PersServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = PersServ.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
/*    
    @GetMapping("/traer/personas")
    @ResponseBody
    public List<Persona> devolverPersona(){
        return PersonaService.getPersonas();
    }

    
    @PostMapping("/crear/persona")
    public String crearPersona(@RequestBody Persona pers){
        PersonaService.savePersona(pers);
        return "Producto creado correctamente";
    }
 
    
    @DeleteMapping("/eliminar/persona/{id}")
    public String eliminarPersona(Long id){
        PersonaService.deletePersona(id);
        return "Producto eliminado correctamente";
    }
    
    @GetMapping("/buscar/persona/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return PersonaService.findPersona(id);
    }

    
    @PutMapping("/editar/persona/{id}")
    public String modificarProducto(@PathVariable int id,@RequestBody Persona pers){
        pers.setId(id);
        PersonaService.savePersona(pers);
        return "Producto modificado exitosamente";
    }
    */
