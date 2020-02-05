package com.educomser.entity.dao.impl;

import com.educomser.entity.Email;
import com.educomser.entity.dao.EmailDao;
import com.educomser.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pc
 */
public class EmailDaoImpl implements EmailDao
{
    private Session session;
    private Transaction tx; 
    
    
    private void iniciarSession()
    {
        session=HibernateUtil.getSessionFactory().openSession(); //Llamanos a nuestra sesion y la abrimos
        tx=session.beginTransaction();
    } 
    
    @Override
    public void create(Email email) {           
        try 
        {
            iniciarSession();
            session.save(email);
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
    public void update(Email email) {
    try 
        {
            iniciarSession();
            session.update(email);
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
    public void delete(Email email) {
    try 
        {
            iniciarSession();
            session.delete(email);
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
    public Email findById(int id)
    {
        Email email=null;
        try
        {
            iniciarSession();
            email=(Email) session.get(Email.class, id); //Esto busca un obj email (select * from emailwhere id=?)
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
        
        return email;
    }

    @Override
    public List<Email> getAll() 
    {
        List<Email> list=new ArrayList<Email>();
    
        try
        {
            iniciarSession();
            list= session.createQuery("from Email").list(); //SQL           
            
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
    
}
