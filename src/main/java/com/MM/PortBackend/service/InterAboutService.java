package com.MM.PortBackend.service;

import com.MM.PortBackend.model.AboutMe;
import java.util.List;


public interface InterAboutService {
    //Trae todas las about
    public List<AboutMe> getAboutMe();
    //Guarda un about
    public void saveAboutMe(AboutMe about);
    //Eliminamos un about
    public void deleteAboutMe(int id);
}
