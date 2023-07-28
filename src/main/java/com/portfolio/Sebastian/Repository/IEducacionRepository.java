package com.portfolio.Sebastian.Repository;

import com.portfolio.Sebastian.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion,Integer> {
    public Optional<Educacion> findByNombre(String nombreE);
    public boolean existsByNombre(String nombreE);
}