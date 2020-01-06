/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Juan Carlos
 */
public class UsuariosDAO implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("dashboard");
        String mensaje= "Detalles de todos los usuarios";
        /*try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List resultados = session.createQuery("from Usuarios").list();
            mv.addObject("usuarios",resultados);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            e.printStackTrace();
        }*/
        mv.addObject("mensaje",mensaje);
        return mv;
    }
    
}