package com.educomser.entity.dao.impl;

import com.educomser.entity.Persona;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pc
 */
public class PersonaDaoImpl implements PersonaDao
{
    private Session session;
    private Transaction tx; 
    
    
    private void iniciarSession()
    {
        session=HibernateUtil.getSessionFactory().openSession(); //Llamanos a nuestra sesion y la abrimos
        tx=session.beginTransaction();
    } 
    
    @Override
    public void create(Persona persona) {           
        try 
        {
            iniciarSession();
            session.save(persona);
            tx.commit();   
        }
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
        {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
        }
        finally
        {
            session.close();                    
        }
    }

    @Override
    public void update(Persona persona) {
    try 
        {
            iniciarSession();
            session.update(persona);
            tx.commit();   
        }
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
        {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
        }
        finally
        {
            session.close();                    
        }
    }

    @Override
    public void delete(Persona persona) {
    try 
        {
            iniciarSession();
            session.delete(persona);
            tx.commit();   
        }
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
        {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
        }
        finally
        {
            session.close();                    
        }
    }

    @Override
    public Persona findById(int id)
    {
        Persona persona=null;
        try
        {
            iniciarSession();
            persona=(Persona) session.get(Persona.class, id); //Esto busca un obj persona (select * from personawhere id=?)
            tx.commit();   
        }
              catch (HibernateException ex) //En caso de presentarse alguna excepcion
              {
                  tx.rollback();
                  Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
              }
              finally
              {
                  session.close();                    
              } 
        
        return persona;
    }

    @Override
    public List<Persona> getAll() 
    {
        List<Persona> list=new ArrayList<Persona>();
    
        try
        {
            iniciarSession();
            list= session.createQuery("from Persona").list(); //SQL           
            
            tx.commit();   
        }
        
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
              {
                  tx.rollback();
                  Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
              }
              finally
              {
                  session.close();                    
              } 
        
        return list;  
    }

    @Override
    public List<Persona> getAllPersonasAndCorreos() {
   
          List<Persona> list=new ArrayList<Persona>();
    
        try
        {
            iniciarSession();
            
            String query="SELECT p FROM Persona AS p JOIN FETCH p.emails"; //CREAMOS EL QUERY
            
            list= session.createQuery(query).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list() ; //PONEMOS EL QUERY           
            
            tx.commit();   
        }
        
        catch (HibernateException ex) 
              {
                  tx.rollback();
                  Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
              }
              finally
              {
                  session.close();                    
              } 
        
        return list;  
    
    }

    @Override
    public Persona findPersonaAndCorreosById(int id) {    
        Persona persona=null;
        try
        {
            iniciarSession();
            
            String query="SELECT p FROM Persona AS p JOIN FETCH p.emails WHERE p.id=:idparam";
            
            persona=(Persona) session.createQuery(query).setParameter("idparam", id).uniqueResult();
            
            tx.commit();   
        }
              catch (HibernateException ex) //En caso de presentarse alguna excepcion
              {
                  tx.rollback();
                  Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
              }
              finally
              {
                  session.close();                    
              } 
        
        return persona;
    }
    
}
