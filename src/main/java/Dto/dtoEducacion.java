/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Sebastián
 */
public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String imgE;
    @NotBlank
    private String anioE;
    @NotBlank
    private String habilidades;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String imgE, String anioE, String habilidades) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgE = imgE;
        this.anioE = anioE;
        this.habilidades = habilidades;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    public String getAnioE() {
        return anioE;
    }

    public void setAnioE(String anioE) {
        this.anioE = anioE;
    }

    public String getHabilidadesE() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    
    
}
