package com.MM.PortBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class AboutMe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    //@Size(min=1,max=50,message="No cumple con la longitud")
    private String informacion;
    private String ciudad;
    private String provincia;
    private int edad;

    public AboutMe() {
    }
}