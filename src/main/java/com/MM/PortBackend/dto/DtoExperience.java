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
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFin;
    @NotBlank
    private String imagen;

    public DtoExperience() {
    }

    public DtoExperience(String nombreEmpresa, String infoPuesto, String fechaInicio, String fechaFin, String imagen) {
        this.nombreEmpresa = nombreEmpresa;
        this.infoPuesto = infoPuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imagen = imagen;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
