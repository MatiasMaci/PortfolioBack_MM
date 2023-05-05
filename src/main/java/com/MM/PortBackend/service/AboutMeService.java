package com.MM.PortBackend.service;

import com.MM.PortBackend.model.AboutMe;
import com.MM.PortBackend.repository.InterAboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutMeService implements InterAboutService{

    @Autowired
    private InterAboutRepository IAboutRep;
    
    @Override
    public List<AboutMe> getAboutMe() {
        return IAboutRep.findAll();
    }

    @Override
    public void saveAboutMe(AboutMe about) {
        IAboutRep.save(about);
    }

    @Override
    public void deleteAboutMe(int id) {
        IAboutRep.deleteById(id);
    }
    
}
