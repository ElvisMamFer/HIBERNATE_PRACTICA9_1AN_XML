/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educomser.test.tarea;

import com.educomser.entity.Email;
import com.educomser.entity.Persona;
import com.educomser.entity.dao.EmailDao;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.entity.dao.impl.EmailDaoImpl;
import com.educomser.entity.dao.impl.PersonaDaoImpl;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class EliminaUnCorreo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PersonaDao perDao=new PersonaDaoImpl();
        EmailDao emDao=new EmailDaoImpl();
        
        System.out.println("-- ELIJA UNA PERSONA --");
        for(Persona per: perDao.getAll())
        {
            System.out.println(per);
        }
        
        Scanner in=new Scanner(System.in);
        int clave=in.nextInt();               
        Persona per=perDao.findById(clave);        
                  
        
       // emDao.delete(email);
        
                
        
    }
    
}
