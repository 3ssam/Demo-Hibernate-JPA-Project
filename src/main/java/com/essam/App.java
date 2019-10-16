package com.essam;

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
        Student student = new Student(3,"ahmed",23,"ahmed@a.com");
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(registry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }
}
