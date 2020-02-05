/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.test;

import com.educomser.entity.Email;
import com.educomser.entity.Persona;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.entity.dao.impl.PersonaDaoImpl;
import com.educomser.util.HibernateUtil;
import java.util.Date;

/**
 *
 * @author pc
 */
public class PersonaAdicionar {

    public static void main(String[] args) {

        //Creamos el objeto
        Persona p=new Persona();
        p.setNombre("Samuel Lopez");
        p.setSueldo(1500);
        p.setContrato(true);
        p.setFechaNacimiento(new Date());
                 
        
        Email e1=new Email("samy123@hotmail.com",p);
        Email e2=new Email("samlo@gmail.com",p);
        Email e3=new Email("lopez1942@yahoo.com",p);
        Email e4=new Email("losam@yahoo.com",p);
        Email e5=new Email("samuellopez@yahoo.com",p);
        
        //Adicionamos emails
        p.getEmails().add(e1);
        p.getEmails().add(e2);
        p.getEmails().add(e3);
        p.getEmails().add(e4);
        p.getEmails().add(e5);
        
        //Creamos el Dao
        PersonaDao perDao=new PersonaDaoImpl();
        perDao.create(p);
        
        //Esta funcion solo usamos en aplicaciones de escritorio
        HibernateUtil.closeSessionFactory();
    }
    
}
