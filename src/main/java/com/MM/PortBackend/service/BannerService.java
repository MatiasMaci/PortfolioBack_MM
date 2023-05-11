/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.service;

import com.MM.PortBackend.model.Banner;
import com.MM.PortBackend.repository.InterBannerRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BannerService {
    
    @Autowired
    private InterBannerRepository IBanRepo;
    
    public List<Banner> list(){
        return IBanRepo.findAll();
    }
    
    public Optional<Banner> getOne(int id){
        return IBanRepo.findById(id);
    }
    
    public void save(Banner banner){
        IBanRepo.save(banner);
    }
    
    public void delete(int id){
        IBanRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return IBanRepo.existsById(id);
    }
}
