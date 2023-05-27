/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Sebastian.Repository;

import com.portfolio.Sebastian.Entity.Contacto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sebastián
 */
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
    Optional<Contacto> findByEmail(String email);
    public boolean existsByEmail(String email);
}
