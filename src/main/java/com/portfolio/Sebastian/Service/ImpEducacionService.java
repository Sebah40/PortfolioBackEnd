package com.portfolio.Sebastian.Service;

import com.portfolio.Sebastian.Entity.Educacion;
import com.portfolio.Sebastian.Repository.IEducacionRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    @Autowired IEducacionRepository ieducacionRepository;
    public List<Educacion> list() {
        return ieducacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return ieducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombre(String nombreE){
        return ieducacionRepository.findByNombre(nombreE);
    }
    
    
    public void save(Educacion educacion) {
        ieducacionRepository.save(educacion); 
    }

    public void delete(int id) {
        ieducacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return ieducacionRepository.existsById(id);
    }

    public boolean existsByNombre(String nombreE) {
        return ieducacionRepository.existsByNombre(nombreE);
    }
}