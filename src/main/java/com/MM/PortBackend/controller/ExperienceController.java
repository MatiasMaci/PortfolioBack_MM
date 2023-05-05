/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.controller;

import com.MM.PortBackend.dto.DtoExperience;
import com.MM.PortBackend.model.Experience;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.ExperienceService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
    
    @Autowired
    ExperienceService ExpServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = ExpServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(ExpServ.existsByNombreEmpresa(dtoExp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("Esa experiencia existe"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Experience Exp = new Experience(dtoExp.getNombreEmpresa(),
                                        dtoExp.getInfoPuesto());
        ExpServ.save(Exp);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"),
                                                HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoExperience dtoExp){
        if(!ExpServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(ExpServ.existsByNombreEmpresa(dtoExp.getNombreEmpresa()) && 
                ExpServ.findByNombreEmpresa(dtoExp.getNombreEmpresa())
                        .get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoExp.getNombreEmpresa())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Experience Exp = ExpServ.getOne(id).get();
        Exp.setNombreEmpresa(dtoExp.getNombreEmpresa());
        Exp.setInfoPuesto(dtoExp.getInfoPuesto());
        
        ExpServ.save(Exp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"),
                                                HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!ExpServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        ExpServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"),
                                                HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!ExpServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experience experiencia = ExpServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
}
