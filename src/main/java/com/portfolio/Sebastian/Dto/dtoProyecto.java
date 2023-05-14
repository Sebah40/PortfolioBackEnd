package com.portfolio.Sebastian.Dto;


import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Sebastián
 */
public class dtoProyecto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    @NotBlank
    private String anio;
    @NotBlank
    private String habilidades;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreE, String descripcionE, String imgE, String anioE, String habilidades) {
        this.nombre = nombreE;
        this.descripcion = descripcionE;
        this.img = imgE;
        this.anio = anioE;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreE) {
        this.nombre = nombreE;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcionE) {
        this.descripcion = descripcionE;
    }

    public String getImg() {
        return img;
    }

    public void setImgE(String imgE) {
        this.img = imgE;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnioE(String anioE) {
        this.anio = anioE;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    
    
}