/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @NotNull
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String nombreCurso;
    
    @NotNull
    private String infoCurso;
    
    @NotNull
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String fechaInicio;
    
    @NotNull
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String fechaFin;
    
    @NotNull
    private String imagen;

    public Education() {
    }

    public Education(String nombreCurso, String infoCurso, String fechaInicio, 
            String fechaFin, String imagen) {
        this.nombreCurso = nombreCurso;
        this.infoCurso = infoCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imagen = imagen;
    }

    
}
