/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Sebastian.Controller;

import com.portfolio.Sebastian.Dto.dtoExperiencia;
import com.portfolio.Sebastian.Entity.Experiencia;
import com.portfolio.Sebastian.Security.Controller.Mensaje;
import com.portfolio.Sebastian.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastián
 */
@RestController
@RequestMapping("explab")
@CrossOrigin(origins = {"https://yoprogramosh2023.web.app"})
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia) {
        if (StringUtils.isBlank(dtoexperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (sExperiencia.existsByNombreE(dtoexperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexperiencia.getNombreE(), dtoexperiencia.getDescripcionE());

        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexperiencia) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID does not exist"), HttpStatus.BAD_REQUEST);
        }

        if (sExperiencia.existsByNombreE(dtoexperiencia.getNombreE()) && sExperiencia.getByNombreE(dtoexperiencia.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Experience already exists"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoexperiencia.getNombreE())) {
            return new ResponseEntity(new Mensaje("Name is mandatory"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexperiencia.getNombreE());
        experiencia.setDescripcionE(dtoexperiencia.getDescripcionE());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Saved"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("Does not exist"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        sExperiencia.delete(id);

        return new ResponseEntity(new Mensaje("Deleted"), HttpStatus.OK);
    }
}
