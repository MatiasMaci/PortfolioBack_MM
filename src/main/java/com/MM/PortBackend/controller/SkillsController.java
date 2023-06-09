/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.controller;

import com.MM.PortBackend.dto.DtoSkills;
import com.MM.PortBackend.model.Skills;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.SkillsService;
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
@RequestMapping("skills")
@CrossOrigin(origins = {"http://localhost:4200","https://portfoliofrontmm.web.app"})
public class SkillsController {
    
    @Autowired
    SkillsService SkillServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = SkillServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNombreSkill())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(SkillServ.existsByNombreSkill(dtoSkill.getNombreSkill())){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Skills Skill = new Skills(dtoSkill.getNombreSkill(),
                                        dtoSkill.getPercent());
        SkillServ.save(Skill);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"),
                                                HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoSkills dtoSkill){
        if(!SkillServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(SkillServ.existsByNombreSkill(dtoSkill.getNombreSkill()) && 
                SkillServ.findByNombreSkill(dtoSkill.getNombreSkill())
                        .get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getNombreSkill())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Skills Skill = SkillServ.getOne(id).get();
        Skill.setNombreSkill(dtoSkill.getNombreSkill());
        Skill.setPercent(dtoSkill.getPercent());
        
        SkillServ.save(Skill);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"),
                                                HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!SkillServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        SkillServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Habilidad eliminada"),
                                                HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!SkillServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skill = SkillServ.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}
