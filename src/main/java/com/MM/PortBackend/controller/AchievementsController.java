/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.controller;

import com.MM.PortBackend.model.Achievements;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.AchievementsService;
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
@RequestMapping("achievements")
@CrossOrigin(origins = "http://localhost:4200")
public class AchievementsController {
    
    @Autowired
    AchievementsService AchiServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Achievements>> list(){
        List<Achievements> list = AchiServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    //Funcion para crear
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Achievements logros){
        if(StringUtils.isBlank(logros.getInformacion())){
            return new ResponseEntity(new Mensaje("la informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }

        Achievements Achi = new Achievements(logros.getInformacion());
        AchiServ.save(Achi);
        
        return new ResponseEntity(new Mensaje("Logro agregado"),
                                                HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Achievements logros){
        if(!AchiServ.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(logros.getInformacion())){
            return new ResponseEntity(new Mensaje("la informacion es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        
        Achievements Achi = AchiServ.getOne(id).get();
        Achi.setInformacion(logros.getInformacion());
        
        AchiServ.save(Achi);
        return new ResponseEntity(new Mensaje("Logro actualizado"),
                                                HttpStatus.OK);
    }

    //Funcion eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!AchiServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        AchiServ.delete(id);
        
        return new ResponseEntity(new Mensaje("Logro eliminado"),
                                                HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Achievements> getById(@PathVariable("id") int id){
        if(!AchiServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Achievements achievements = AchiServ.getOne(id).get();
        return new ResponseEntity(achievements, HttpStatus.OK);
    }
    
}
