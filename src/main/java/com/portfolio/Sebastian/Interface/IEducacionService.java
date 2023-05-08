package com.portfolio.Sebastian.Interface;


import com.portfolio.Sebastian.Entity.Educacion;
import java.util.List;
/**
 *
 * @author Sebastián
 */
public interface IEducacionService {
    
        public List<Educacion> list();
    
    public void saveEducacion(Educacion educacion);
    
    public void deleteEducacion(Long id);
    
    public Educacion findEducacion(Long id);
    
}
