
package com.educomser.test;

import com.educomser.entity.Email;
import com.educomser.entity.Persona;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.entity.dao.impl.PersonaDaoImpl;
import com.educomser.util.HibernateUtil;

public class PersonaBuscarCorreos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("-- LISTADO DE PERSONAS CON SUS CORREOS --");
        
        PersonaDao perDao=new PersonaDaoImpl();
        
        for(Persona per: perDao.getAllPersonasAndCorreos())
        {
            System.out.println("Id : "+per.getId());
            System.out.println("NOMBRE: " +per.getNombre());
            
            for(Email email: per.getEmails())
            {
            System.out.println(" - "+email.getCorreo());
        }}
    
        HibernateUtil.closeSessionFactory();
    }
}

/*
    private int id;
    private String nombre;
    private double sueldo;
    private boolean contrato;
    private Date fechaNacimiento;
    private Set<Email> emails=new HashSet<Email>(); //Lista desordenada
    */