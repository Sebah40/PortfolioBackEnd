/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Sebastian.Controller;

import com.portfolio.Sebastian.Entity.Contacto;
import com.portfolio.Sebastian.Dto.dtoContacto;
import java.util.List;
import com.portfolio.Sebastian.Security.Controller.Mensaje;
import com.portfolio.Sebastian.Service.ContactoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Sebastián
 */

@RestController
@CrossOrigin(origins = {"https://yoprogramosh2023.web.app"})
@RequestMapping("/contacto")
public class ContactoController {
        @Autowired ContactoService contactoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Contacto>> list() {
        List<Contacto> list = contactoService.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoContacto dtocontacto){
        if(StringUtils.isBlank(dtocontacto.getEmail())){
            return new ResponseEntity(new Mensaje("Contact info mandatory"),HttpStatus.BAD_REQUEST);
        }

        System.out.println(dtocontacto.getMessage());
        Contacto cOntacto = new Contacto(dtocontacto.getEmail(), dtocontacto.getMessage());

        contactoService.save(cOntacto);
        
        return new ResponseEntity(new Mensaje("Sent"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id") int id) {
        if (!contactoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Does not exist"), HttpStatus.NOT_FOUND);
        }
        Contacto cOntacto = contactoService.getOne(id).get();
        return new ResponseEntity(cOntacto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!contactoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        contactoService.delete(id);
        
        return new ResponseEntity(new Mensaje("Deleted"), HttpStatus.OK);
    }
}
