package com.portfolio.Sebastian.Repository;

import com.portfolio.Sebastian.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastián
 */

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {
    
    public Optional<Persona> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}