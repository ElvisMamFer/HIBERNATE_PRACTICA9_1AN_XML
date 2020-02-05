/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.entity.dao;

import com.educomser.entity.Email;
import com.educomser.entity.Persona;
import java.util.List;

/**
 *
 * @author pc
 */
public interface EmailDao {
    
    public void create(Email email);
    public void update(Email email);
    public void delete(Email email);
    public Email findById(int id);
    public List<Email> getAll();
}
