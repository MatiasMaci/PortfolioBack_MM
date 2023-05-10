/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.controller;

import com.MM.PortBackend.dto.DtoProject;
import com.MM.PortBackend.model.Projects;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.ProjectService;
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
@RequestMapping("project")
@CrossOrigin(origins = {"http://localhost:4200","https://portfoliofrontmm.web.app"})
public class ProjectController {
    
    @Autowired
    ProjectService ProServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Projects>> list(){
        List<Projects> list = ProServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProject dtoProj){
        if(StringUtils.isBlank(dtoProj.getNombreProject())){
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(ProServ.existsByNombreProject(dtoProj.getNombreProject())){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProj.getInformacion())){
            return new ResponseEntity<>(new Mensaje("La informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Projects Proj = new Projects(dtoProj.getNombreProject(),
                                        dtoProj.getInformacion());
        ProServ.save(Proj);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"),
                                                HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoProject dtoProj){
        if(!ProServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(ProServ.existsByNombreProject(dtoProj.getNombreProject()) && 
                ProServ.findByNombreProject(dtoProj.getNombreProject())
                        .get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProj.getNombreProject())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),
                                                  HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoProj.getInformacion())){
            return new ResponseEntity<>(new Mensaje("La informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        Projects Proj = ProServ.getOne(id).get();
        Proj.setNombreProject(dtoProj.getNombreProject());
        Proj.setInformacion(dtoProj.getInformacion());
        
        ProServ.save(Proj);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"),
                                                HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!ProServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        ProServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado"),
                                                HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Projects> getById(@PathVariable("id") int id){
        if(!ProServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Projects proj = ProServ.getOne(id).get();
        return new ResponseEntity(proj, HttpStatus.OK);
    }
    
}
