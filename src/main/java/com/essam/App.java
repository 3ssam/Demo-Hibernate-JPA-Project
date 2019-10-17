package com.essam;

import com.essam.models.Labtop;
import com.essam.models.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.persistence.ParameterMode;
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

        Query q = factory.openSession().createSQLQuery("CALL getAllstudent()").addEntity(Student.class);
        List<Student> students = q.list();
        for (Student s : students)
            System.out.println(s);

        ProcedureCall call = factory.openSession().createStoredProcedureCall("getSomeData");
        call.registerParameter("P_id",int.class, ParameterMode.IN).bindValue(11);
        call.registerParameter("P_name",String.class, ParameterMode.OUT);
        call.registerParameter("P_age",int.class, ParameterMode.OUT);
        ProcedureOutputs outputs = call.getOutputs();
        int age = (int)outputs.getOutputParameterValue("P_age");
        String name = (String)outputs.getOutputParameterValue("P_name");
        System.out.println(age);
        System.out.println(name);

    }
}
