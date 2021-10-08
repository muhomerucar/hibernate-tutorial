package com.learninghibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        // start with creating factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try {
            // and then create session
            Session session = factory.getCurrentSession();

            //start transaction
            session.beginTransaction();

            //query students
            List<Student> students = session.createQuery("from Student").getResultList();

            //display students in database
            displayStudents(students);

            //query students where last_name = 'Toretto'
            students = session.createQuery("from Student student where student.lastName='Toretto'").getResultList();
            displayStudents(students);

            //query students where first_name = 'Mia' OR last_name = 'Ortiz'
            students = session.createQuery("from Student student where student.firstName ='Mia'" + "OR student.lastName='Ortiz'").getResultList();
            displayStudents(students);

            //query students where email LIKE '%fastandfurios.com'
            students = session.createQuery("from Student student where email LIKE '%fastandfurious.com'").getResultList();
            displayStudents(students);

            //commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }


    }

    public static void displayStudents(List<Student> students){
        for(Student student : students){
            System.out.println(student);
        }
    }
}
