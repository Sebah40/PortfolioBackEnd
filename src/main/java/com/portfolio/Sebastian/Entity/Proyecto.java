package com.portfolio.Sebastian.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String descripcion;

    @Size(min = 1, max = 150, message = "No cumple con la longitud")
    private String img;
    
    @Size(min = 1, max = 150, message = "No cumple con la longitud")
    private String url;
    
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String anio;
    
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    private String habilidades;

    public Proyecto() {
    }
    
    public Proyecto(String nombreE, String descripcionE, String imgE, String anioE, String habilidadesE, String url) {
        this.nombre = nombreE;
        this.descripcion = descripcionE;
        this.img = imgE;
        this.anio = anioE;
        this.habilidades = habilidadesE;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setImg(String imgE) {
        this.img = imgE;
    }
    
    public String getAnio() {
        return anio;
    }

    public void setAnio(String anioE) {
        this.anio = anioE;
    }
    
    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidadesE) {
        this.habilidades = habilidadesE;
    }
}