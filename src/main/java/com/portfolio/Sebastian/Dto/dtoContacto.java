/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Sebastian.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Sebastián
 */
public class dtoContacto {
    @NotBlank
    private String email;
    @NotBlank
    private String message;

    public dtoContacto() {
    }

    public dtoContacto(String email, String message) {
        this.email = email;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
