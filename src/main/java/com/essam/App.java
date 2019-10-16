package com.essam;

import com.essam.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Student student = new Student(1,"essam",22,"essam@a.com");
        Configuration configuration = new Configuration();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.save(student);
    }
}
