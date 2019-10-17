package com.essam;

import com.essam.models.Labtop;
import com.essam.models.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Labtop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(registry);
        Session session = factory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Student where age > 15");
        List<Student> list = query.list();

        for (Student student : list) {
            //System.out.println(student);
        }

        query = session.createQuery("select id,age,name from Student where id = 7");
        Object[] s = (Object[]) query.uniqueResult();
        System.out.println(s[0] + " : " + s[1] + " : " + s[2]);

        session.getTransaction().commit();
        session.close();


    }
}
