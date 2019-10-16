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

        Student student = null;
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(registry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        student = (Student) session.get(Student.class,2);
        transaction.commit();
        System.out.println(student);
    }
}
