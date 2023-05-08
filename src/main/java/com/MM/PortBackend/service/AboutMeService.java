package com.MM.PortBackend.service;

import com.MM.PortBackend.model.AboutMe;
import com.MM.PortBackend.repository.InterAboutRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AboutMeService{

    @Autowired
    private InterAboutRepository IAboutRep;
    
    public List<AboutMe> list() {
        return IAboutRep.findAll();
    }
    
    public Optional<AboutMe> getOne(int id){
        return IAboutRep.findById(id);
    }

    public void save(AboutMe about) {
        IAboutRep.save(about);
    }

    public void delete(int id) {
        IAboutRep.deleteById(id);
    }
    
    public boolean existsById(int id){
        return IAboutRep.existsById(id);
    }
}
