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
        Student student = new Student(1,"ahmed",22,"ahmed@a.com");
        Labtop labtop = new Labtop(1,"Dell");
        student.getLabtop().add(labtop);
        labtop.setStudent(student);
        labtop = new Labtop(2,"hp");
        student.getLabtop().add(labtop);
        labtop.setStudent(student);
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Labtop.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(registry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(labtop);
        labtop = new Labtop(1,"Dell");
        session.save(labtop);
        transaction.commit();
    }
}
