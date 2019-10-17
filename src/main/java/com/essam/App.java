package com.essam;

import com.essam.models.Labtop;
import com.essam.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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

        Random random = new Random();

        for (int i = 1 ; i <= 50 ; i++){
            Student student = new Student(i,"name "+i,random.nextInt(20),"Email_"+i+"@a.com");
            session.save(student);
        }
        session.getTransaction().commit();
        session.close();


    }
}
