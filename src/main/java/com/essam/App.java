package com.essam;

import com.essam.models.Labtop;
import com.essam.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Student student =null;
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Labtop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(registry);
        Session session1 = factory.openSession();
        student = (Student) session1.get(Student.class,1);

        System.out.println(student);
        session1.beginTransaction().commit();
        student = (Student) session1.get(Student.class,1);
        System.out.println(student);
        session1.beginTransaction().commit();
        session1.close();


        Session session2 = factory.openSession();
        student = (Student) session2.get(Student.class,1);
        System.out.println(student);
        session2.beginTransaction().commit();
        session2.close();
    }
}
