package com.iisc.year2015;

import com.iisc.year2015.Database;
import javafx.scene.chart.PieChart;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Dmitry on 27.11.2015.
 */
public class workdatabase {

    private static SessionFactory dbSessions;

    private void createSessionFactory(){
        dbSessions = new AnnotationConfiguration()
                .configure("/resources/hibernate.cfg.xml")
                .addAnnotatedClass(Database.class)
                .buildSessionFactory();
    }

    public String checkUser(String login, String pas) {
        createSessionFactory();
        Session session = dbSessions.openSession();
        try
        {
            Query query = session.createQuery("from Database where login = :login AND pas = :pas");
            query.setParameter("login", login);
            query.setParameter("pas", pas);
            List list = query.list();
            String otv ="";
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                Database fm = (Database) iterator.next();
                otv = otv + "Привет " + fm.getFirst_name() + " " + fm.getLast_name();
                //System.out.print("Last name: " + fm.getLastName() + "\nFirst name: " + fm.getFirstName() + "\nMiddle name: " + fm.getMiddleName() + "\nAge: " + fm.getAge() + "\n\n");
            }
            if (otv == "") otv = "Ошибка";
            return otv;
        }
        catch (HibernateException e) {e.printStackTrace();} finally {session.close();}
    return "error";
    }
}
