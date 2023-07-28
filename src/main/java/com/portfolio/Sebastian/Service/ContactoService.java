/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Sebastian.Service;

/**
 *
 * @author Sebastián
 */

import com.portfolio.Sebastian.Entity.Contacto;
import com.portfolio.Sebastian.Repository.ContactoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ContactoService {
    @Autowired
    ContactoRepository contactoRepository;
    
    public List<Contacto> list(){
        return contactoRepository.findAll();
    }
    
    public Optional<Contacto> getOne(int id) {
        return contactoRepository.findById(id);
    }
    
    public Optional<Contacto> getByEmail(String Email){
        return contactoRepository.findByEmail(Email);
    }
    
    public void save(Contacto message){
        contactoRepository.save(message);
    }
    public void delete(int id){
        contactoRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return contactoRepository.existsById(id);
    }
    public boolean existsByEmail(String email){
        return contactoRepository.existsByEmail(email);
    }
}
