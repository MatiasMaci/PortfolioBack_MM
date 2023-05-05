/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.dto;

import javax.validation.constraints.NotBlank;


public class DtoExperience {
    
    @NotBlank
    private String nombreEmpresa;
    @NotBlank
    private String infoPuesto;

    public DtoExperience() {
    }

    public DtoExperience(String nombreEmpresa, String infoPuesto) {
        this.nombreEmpresa = nombreEmpresa;
        this.infoPuesto = infoPuesto;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getInfoPuesto() {
        return infoPuesto;
    }

    public void setInfoPuesto(String infoPuesto) {
        this.infoPuesto = infoPuesto;
    }

    
}
