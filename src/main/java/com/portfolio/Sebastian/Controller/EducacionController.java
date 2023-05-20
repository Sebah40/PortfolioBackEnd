package com.portfolio.Sebastian.Controller;
import com.portfolio.Sebastian.Dto.dtoEducacion;
import com.portfolio.Sebastian.Entity.Educacion;
import com.portfolio.Sebastian.Security.Controller.Mensaje;
import com.portfolio.Sebastian.Service.ImpEducacionService;
import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Sebastián
 */


@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://yoprogramosh2023.web.app"})
public class EducacionController {
    @Autowired ImpEducacionService impeducacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impeducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impeducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id does not exist"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = impeducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!impeducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID does not exist"), HttpStatus.NOT_FOUND);
        }
        impeducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Deleted"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("Field name is mandatory"), HttpStatus.BAD_REQUEST);
        }
        if(impeducacionService.existsByNombre(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("Name already exists."), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoeducacion.getNombre(),dtoeducacion.getDescripcion(), dtoeducacion.getImg(), dtoeducacion.getAnio(), dtoeducacion.getHabilidades());
        impeducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Created."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!impeducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID does not exist"), HttpStatus.NOT_FOUND);
        }
        if(impeducacionService.existsByNombre(dtoeducacion.getNombre()) && impeducacionService.getByNombre(dtoeducacion.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Name already exists"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombre())){
            return new ResponseEntity(new Mensaje("Field name is mandatory"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getImg())){
            return new ResponseEntity(new Mensaje("Field image is mandatory"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getHabilidades())){
            return new ResponseEntity(new Mensaje("Field abilities is mandatory"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getAnio())){
            return new ResponseEntity(new Mensaje("Field year is mandatory"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = impeducacionService.getOne(id).get();
        educacion.setNombre(dtoeducacion.getNombre());
        educacion.setDescripcion(dtoeducacion.getDescripcion());
        educacion.setImg(dtoeducacion.getImg());
        educacion.setHabilidades(dtoeducacion.getHabilidades());
        educacion.setAnio(dtoeducacion.getAnio());
        impeducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Update successful"), HttpStatus.OK);
    }
}