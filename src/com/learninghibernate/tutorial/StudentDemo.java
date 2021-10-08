package com.learninghibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo {
    public static void main(String[] args) {

        // start with creating factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // and then create session
        Session session = factory.getCurrentSession();

        try{
            // Step 1 - Create Student Object
            Student student = new Student("Letty","Ortiz","ortiz@fastandfurios.com","Law");

            //Step 2 - Start a transaction
            session.beginTransaction();

            //Step 3 - save the object
            session.save(student);
            System.out.println(student + " has been saved...");

            //Step 3 - commit the transaction
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
