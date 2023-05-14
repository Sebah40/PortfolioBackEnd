package com.portfolio.Sebastian.Repository;

import com.portfolio.Sebastian.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto,Integer> {
    public Optional<Proyecto> findByNombre(String nombreE);
    public boolean existsByNombre(String nombreE);
}