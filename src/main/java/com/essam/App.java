package com.essam;

import com.essam.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //Student student = new Student(111,"essam",22,"essam@a.com");
        Student student = null;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
        EntityManager manager = factory.createEntityManager();
        student =  manager.find(Student.class,9);
        System.out.println(student);
        manager.getTransaction().begin();
        Student student1 = new Student(1211,"essam",22,"essam@a.com");
        manager.persist(student1);
        manager.getTransaction().commit();

        System.out.println(student1);


    }
}
