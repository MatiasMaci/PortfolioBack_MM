/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.controller;

import com.MM.PortBackend.dto.DtoEducation;
import com.MM.PortBackend.model.Education;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.EducationService;
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
@RequestMapping("education")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    
    @Autowired
    EducationService EduServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = EduServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getNombreCurso())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(EduServ.existsByNombreCurso(dtoEdu.getNombreCurso())){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getInfoCurso())){
            return new ResponseEntity(new Mensaje("La informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getFechaInicio())){
            return new ResponseEntity(new Mensaje("La fecha de inicio es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getFechaFin())){
            return new ResponseEntity(new Mensaje("La fecha de fin es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getImagen())){
            return new ResponseEntity(new Mensaje("La URL es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Education Edu = new Education(dtoEdu.getNombreCurso(),
                                        dtoEdu.getInfoCurso(), 
                                        dtoEdu.getFechaInicio(),
                                        dtoEdu.getFechaFin(), 
                                        dtoEdu.getImagen());
        EduServ.save(Edu);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"),
                                                HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoEducation dtoEdu){
        if(!EduServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(EduServ.existsByNombreCurso(dtoEdu.getNombreCurso()) && 
                EduServ.findByNombreCurso(dtoEdu.getNombreCurso())
                        .get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getNombreCurso())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getInfoCurso())){
            return new ResponseEntity(new Mensaje("La informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getFechaInicio())){
            return new ResponseEntity(new Mensaje("La fecha de inicio es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getFechaFin())){
            return new ResponseEntity(new Mensaje("La fecha de fin es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getImagen())){
            return new ResponseEntity(new Mensaje("La URL es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Education Edu = EduServ.getOne(id).get();
        Edu.setNombreCurso(dtoEdu.getNombreCurso());
        Edu.setInfoCurso(dtoEdu.getInfoCurso());
        Edu.setFechaInicio(dtoEdu.getFechaInicio());
        Edu.setFechaFin(dtoEdu.getFechaFin());
        Edu.setImagen(dtoEdu.getImagen());
        
        EduServ.save(Edu);
        return new ResponseEntity(new Mensaje("Educacion actualizada"),
                                                HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!EduServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        EduServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada"),
                                                HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!EduServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Education educacion = EduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
}
