/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.dto;

import javax.validation.constraints.NotBlank;


public class DtoEducation {
    
    @NotBlank
    private String nombreCurso;
    @NotBlank
    private String infoCurso;

    public DtoEducation() {
    }

    public DtoEducation(String nombreCurso, String infoCurso) {
        this.nombreCurso = nombreCurso;
        this.infoCurso = infoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getInfoCurso() {
        return infoCurso;
    }

    public void setInfoCurso(String infoCurso) {
        this.infoCurso = infoCurso;
    } 
}