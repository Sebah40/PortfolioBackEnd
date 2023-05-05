/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
package com.portfolio.Sebastian.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombreE;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String descripcionE;

    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String imgE;
    
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String anioE;
    
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    private String habilidadesE;

    public Educacion(String nombreE, String descripcionE, String imgE, String anioE, String habilidadesE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
        this.anioE = anioE;
        this.habilidadesE = habilidadesE;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombreE;
    }

    public void setNombre(String nombre) {
        this.nombreE = nombre;
    }

    public String getDescripcion() {
        return descripcionE;
    }

    public void setDescripcion(String descripcion) {
        this.descripcionE = descripcion;
    }

    public String getImg() {
        return imgE;
    }

    public void setImg(String img) {
        this.imgE = img;
    }
    
    public String getAnio() {
        return anioE;
    }

    public void setAnio(String anio) {
        this.anioE = anio;
    }
    
    public String getHabilidades() {
        return habilidadesE;
    }

    public void setHabilidades(String habilidades) {
        this.habilidadesE = habilidades;
    }
}
*/