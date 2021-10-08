package com.learninghibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ReadStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        Scanner scanner = new Scanner(System.in);

        try {

            //start transaction
            session.beginTransaction();

            //read Student from database
            System.out.println("Please enter student id to get detailed information about student");
            int studentId = scanner.nextInt();
            System.out.println("\nGetting student with id: " +studentId);
            Student student = session.get(Student.class,studentId);
            System.out.println(student);

            //commit the transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
