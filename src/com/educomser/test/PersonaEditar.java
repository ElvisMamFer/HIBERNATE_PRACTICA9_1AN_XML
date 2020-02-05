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
public class PersonaEditar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        
        System.out.print("-- EDITAR PERSONA --");
        System.out.println("Ingrese el Id de la persona a Editar");
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
            System.out.println("SULEDO:"+per.getSueldo()); 
            System.out.println("CONTRATADO:"+ (per.isContrato()?"SI":"NO"));
            System.out.println("FECHA NACIMIENTO:"+ per.getFechaNacimiento());
            System.out.println("¿Desea modificar el nombre?");
            String resp=in.next().toUpperCase();
            if(resp.contains("S"))
            {                
                System.out.println("Ingrese el nuevo nombre:");
                per.setNombre(in.next());                
            }              
            
            perDao.update(per);
            System.out.println("Ha finalizado la edicion.");
        }
        else
        {
            System.out.println("El ID ingresado no existe.");
        }
        
        //Cerramos session
        HibernateUtil.closeSessionFactory();
    }    
}
