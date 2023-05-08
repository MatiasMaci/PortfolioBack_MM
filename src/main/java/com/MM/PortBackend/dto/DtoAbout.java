/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MM.PortBackend.dto;

import javax.validation.constraints.NotBlank;


public class DtoAbout {
    
    @NotBlank
    private String informacion;
    
    @NotBlank
    private String ciudad;

    @NotBlank
    private String provincia;
    
    @NotBlank
    private int edad;

    public DtoAbout() {
    }

    public DtoAbout(String informacion, String ciudad, String provincia, int edad) {
        this.informacion = informacion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.edad = edad;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
