
package com.educomser.test;

import com.educomser.entity.Email;
import com.educomser.entity.Persona;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.entity.dao.impl.PersonaDaoImpl;
import com.educomser.util.HibernateUtil;
import java.util.Scanner;

public class PersonaListarCorreos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    
        System.out.println("-- LISTADO DE PERSONAS CON SUS CORREOS --");
        
        PersonaDao perDao=new PersonaDaoImpl();
        
        for(Persona per: perDao.getAllPersonasAndCorreos())
        {            
            for(Email email: per.getEmails())
            {
                System.out.println(email.getCorreo()+" - "+per.getNombre());
            }
        
        }
    
        HibernateUtil.closeSessionFactory();
    }
}
