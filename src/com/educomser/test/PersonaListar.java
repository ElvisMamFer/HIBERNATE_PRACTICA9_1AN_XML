/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.test;

import com.educomser.entity.Persona;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.entity.dao.impl.PersonaDaoImpl;
import com.educomser.util.HibernateUtil;
/**
 *
 * @author pc
 */
public class PersonaListar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("-- LISTADO DE PERSONAS --");
        
        PersonaDao perDao=new PersonaDaoImpl();
        for(Persona per: perDao.getAll())
        {
            System.out.println(per);
        }
    
        HibernateUtil.closeSessionFactory();
    }
}
