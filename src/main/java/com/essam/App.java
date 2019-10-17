package com.essam;

import com.essam.models.Labtop;
import com.essam.models.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Map;
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

        SQLQuery query = session.createSQLQuery("select id ,name,age from student where age > 15");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Map> list = query.list();

        for (Map o : list) {
            System.out.println(o.get("id") + "    "+o.get("name")+"     "+o.get("age"));
        }

        query = session.createSQLQuery("select * from student where age > 18");
        query.addEntity(Student.class);
        List<Student> list1 = query.list();

        for (Student o : list1) {
            System.out.println(o);
        }

        //query = session.createQuery("select id,age,name from Student s where s.id = :param");
        //query.setParameter("param",9);
        //Object[] s = (Object[]) query.uniqueResult();
        //System.out.println(s[0] + " : " + s[1] + " : " + s[2]);

        session.getTransaction().commit();
        session.close();


    }
}
