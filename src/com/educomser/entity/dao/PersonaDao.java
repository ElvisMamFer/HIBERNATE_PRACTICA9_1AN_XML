/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.entity.dao;

import com.educomser.entity.Persona;
import java.util.List;

/**
 *
 * @author pc
 */
public interface PersonaDao {
    
    public void create(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
    public Persona findById(int id);
    public Persona findPersonaAndCorreosById(int id);
    public List<Persona> getAll();
    public List<Persona> getAllPersonasAndCorreos();
}
