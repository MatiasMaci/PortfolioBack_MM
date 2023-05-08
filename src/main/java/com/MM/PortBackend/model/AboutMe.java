package com.MM.PortBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
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
    
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String ciudad;
    
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String provincia;
    
    private int edad;

    public AboutMe() {
    }

    public AboutMe(String informacion, String ciudad, String provincia, int edad) {
        this.informacion = informacion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.edad = edad;
    }
}