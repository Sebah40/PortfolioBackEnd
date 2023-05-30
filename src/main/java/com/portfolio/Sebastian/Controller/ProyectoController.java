package com.portfolio.Sebastian.Controller;
import com.portfolio.Sebastian.Dto.dtoProyecto;
import com.portfolio.Sebastian.Entity.Proyecto;
import com.portfolio.Sebastian.Security.Controller.Mensaje;
import com.portfolio.Sebastian.Service.ImpProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://yoprogramosh2023.web.app"})
public class ProyectoController {
    @Autowired ImpProyectoService impproyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = impproyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!impproyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("Id does not exist"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = impproyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!impproyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID does not exist"), HttpStatus.NOT_FOUND);
        }
        impproyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Deleted"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto){
        if(StringUtils.isBlank(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("Field name is mandatory"), HttpStatus.BAD_REQUEST);
        }
        if(impproyectoService.existsByNombre(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("Name already exists."), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(dtoproyecto.getNombre(),dtoproyecto.getDescripcion(), dtoproyecto.getImg(), dtoproyecto.getAnio(), dtoproyecto.getHabilidades(), dtoproyecto.getUrl());
        impproyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Created."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto){
        if(!impproyectoService.existsById(id)){
            return new ResponseEntity(new Mensaje("ID does not exist"), HttpStatus.NOT_FOUND);
        }
        if(impproyectoService.existsByNombre(dtoproyecto.getNombre()) && impproyectoService.getByNombre(dtoproyecto.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Name already exists"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyecto.getNombre())){
            return new ResponseEntity(new Mensaje("Field name is mandatory"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoproyecto.getImg())){
            return new ResponseEntity(new Mensaje("Field image is mandatory"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoproyecto.getHabilidades())){
            return new ResponseEntity(new Mensaje("Field abilities is mandatory"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyecto.getAnio())){
            return new ResponseEntity(new Mensaje("Field year is mandatory"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = impproyectoService.getOne(id).get();
        proyecto.setNombre(dtoproyecto.getNombre());
        proyecto.setDescripcion(dtoproyecto.getDescripcion());
        proyecto.setImg(dtoproyecto.getImg());
        proyecto.setHabilidades(dtoproyecto.getHabilidades());
        proyecto.setAnio(dtoproyecto.getAnio());
        proyecto.setUrl(dtoproyecto.getUrl());
        impproyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Update successful"), HttpStatus.OK);
    }
}