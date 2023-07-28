package com.portfolio.Sebastian.Service;

import com.portfolio.Sebastian.Entity.Proyecto;
import com.portfolio.Sebastian.Repository.IProyectoRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    @Autowired IProyectoRepository iproyectoRepository;
    public List<Proyecto> list() {
        return iproyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return iproyectoRepository.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombreE){
        return iproyectoRepository.findByNombre(nombreE);
    }
    
    
    public void save(Proyecto proyecto) {
        iproyectoRepository.save(proyecto); 
    }

    public void delete(int id) {
        iproyectoRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return iproyectoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombreE) {
        return iproyectoRepository.existsByNombre(nombreE);
    }
}