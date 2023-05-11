/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.controller;

import com.MM.PortBackend.model.Banner;
import com.MM.PortBackend.security.controller.Mensaje;
import com.MM.PortBackend.service.BannerService;
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
@RequestMapping("banner")
@CrossOrigin(origins = {"http://localhost:4200","https://portfoliofrontmm.web.app"})
public class BannerController {
    
    @Autowired
    BannerService BannerServ;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = BannerServ.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    //Funcion para crear
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Banner banner){
        if(StringUtils.isBlank(banner.getImagen())){
            return new ResponseEntity(new Mensaje("la URL es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }

        Banner ban = new Banner(banner.getImagen());
        BannerServ.save(ban);
        
        return new ResponseEntity(new Mensaje("Banner agregado"),
                                                HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Banner banner){
        if(!BannerServ.existsById(id)){
            return new ResponseEntity<>(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(banner.getImagen())){
            return new ResponseEntity(new Mensaje("la URL es obligatoria"),
                                                  HttpStatus.BAD_REQUEST);
        }
        
        Banner ban = BannerServ.getOne(id).get();
        ban.setImagen(banner.getImagen());
        
        BannerServ.save(ban);
        return new ResponseEntity(new Mensaje("Banner actualizado"),
                                                HttpStatus.OK);
    }

    /*
    //Funcion eliminar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!BannerServ.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"),
                                                 HttpStatus.BAD_REQUEST);
        }
        
        BannerServ.delete(id);
        
        return new ResponseEntity<>(new Mensaje("Banner eliminado"),
                                                HttpStatus.OK);
    }
    */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id") int id){
        if(!BannerServ.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Banner ban = BannerServ.getOne(id).get();
        return new ResponseEntity(ban, HttpStatus.OK);
    }
}
