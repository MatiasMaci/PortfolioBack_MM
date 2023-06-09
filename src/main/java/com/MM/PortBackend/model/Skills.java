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
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @NotNull
    @Size(min=1,max=50,message="No cumple con la longitud")
    private String nombreSkill;
    
    @NotNull
    private int percent;

    public Skills() {
    }

    public Skills(String nombreSkill, int percent) {
        this.nombreSkill = nombreSkill;
        this.percent = percent;
    }
}