/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.controller;

import com.MM.PortBackend.dto.DtoAbout;
import com.MM.PortBackend.model.AboutMe;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.AboutMeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("about")
@CrossOrigin(origins = "http://localhost:4200")
public class AboutController {
    
    @Autowired
    public AboutMeService AboutServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<AboutMe>> list(){
        List<AboutMe> list = AboutServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    /*
    //Funcion para crear
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoAbout dtoAbt){
        if(StringUtils.isBlank(dtoAbt.getInformacion())){
            return new ResponseEntity(new Mensaje("la informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoAbt.getCiudad())){
            return new ResponseEntity(new Mensaje("La ciudad es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoAbt.getProvincia())){
            return new ResponseEntity(new Mensaje("La provincia es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(dtoAbt.getEdad() == 0){
            return new ResponseEntity(new Mensaje("La edad es obligatoria"),
                    HttpStatus.BAD_REQUEST);
        }
        AboutMe pers = new AboutMe(dtoAbt.getInformacion(),dtoAbt.getCiudad(),
                dtoAbt.getProvincia(), dtoAbt.getEdad());
        AboutServ.save(pers);
        
        return new ResponseEntity(new Mensaje("Informacion agregada"),
                                                HttpStatus.OK);
    }
    */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoAbout dtoAbt){
        if(!AboutServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoAbt.getInformacion())){
            return new ResponseEntity(new Mensaje("la informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoAbt.getCiudad())){
            return new ResponseEntity(new Mensaje("La ciudad es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoAbt.getProvincia())){
            return new ResponseEntity(new Mensaje("La provincia es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(dtoAbt.getEdad() == 0){
            return new ResponseEntity(new Mensaje("La edad es obligatoria"),
                    HttpStatus.BAD_REQUEST);
        }
        AboutMe about = AboutServ.getOne(id).get();
        about.setInformacion(dtoAbt.getInformacion());
        about.setCiudad(dtoAbt.getCiudad());
        about.setProvincia(dtoAbt.getProvincia());
        about.setEdad(dtoAbt.getEdad());

        
        AboutServ.save(about);
        return new ResponseEntity(new Mensaje("Informacion actualizada"),
                                                HttpStatus.OK);
    }
    /*
    //Funcion eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!AboutServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        AboutServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Informacion eliminada"),
                                                HttpStatus.OK);
    }
    */
    @GetMapping("/detail/{id}")
    public ResponseEntity<AboutMe> getById(@PathVariable("id") int id){
        if(!AboutServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        AboutMe aboutme = AboutServ.getOne(id).get();
        return new ResponseEntity(aboutme, HttpStatus.OK);
    }
    
}
