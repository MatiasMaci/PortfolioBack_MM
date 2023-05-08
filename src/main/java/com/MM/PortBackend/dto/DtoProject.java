/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.dto;

import javax.validation.constraints.NotBlank;


public class DtoProject {
    
    @NotBlank
    private String nombreProject;
    
    @NotBlank
    private String informacion;

    public DtoProject() {
    }

    public DtoProject(String nombreProject, String informacion) {
        this.nombreProject = nombreProject;
        this.informacion = informacion;
    }

    public String getNombreProject() {
        return nombreProject;
    }

    public void setNombreProject(String nombreProject) {
        this.nombreProject = nombreProject;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
    
}
