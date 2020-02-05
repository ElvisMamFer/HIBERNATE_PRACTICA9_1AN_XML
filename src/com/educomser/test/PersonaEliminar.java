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
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class PersonaEliminar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        System.out.print("-- ELIMINAR PERSONA --");
        System.out.println("Ingrese el Id de la persona a eliminar");
        int id=in.nextInt();
        
        //Instanciamos la clase de acceso a datos
        PersonaDao perDao=new PersonaDaoImpl();        
        Persona per=perDao.findById(id);
            
          
        if(per!=null)
        {
            SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Persona encontrada");
            System.out.println("ID:"+per.getId()); 
            System.out.println("NOMBRE:"+per.getNombre()); 
            
            System.out.println("¿Desea eliminar?");
            String resp=in.next().toUpperCase();
            if(resp.contains("S"))
            {            
                perDao.delete(per);
                System.out.println("Se ha eliminado correctamente.");
            }   
            
        }
        else
        {
            System.out.println("El ID ingresado no existe.");
        }
        
        //Cerramos session
        HibernateUtil.closeSessionFactory();
    }
    
}
