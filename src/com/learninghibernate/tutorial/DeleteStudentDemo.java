package com.learninghibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // and then create session
        Session session = factory.getCurrentSession();

        Scanner scanner = new Scanner(System.in);


        try {
            session.beginTransaction();

            List<Student> students = session.createQuery("from Student ").getResultList();
            displayStudents(students);
            System.out.println("Please enter student id that you want to delete...");
            int studentId = scanner.nextInt();

            Student student = session.get(Student.class, studentId);
            System.out.println(student + " is being deleted");
            session.delete(student);


            session.getTransaction().commit();
            System.out.println("Done!");



        }finally {
            factory.close();
        }
    }

    public static void displayStudents(List<Student> students){
        for(Student student : students){
            System.out.println(student);
        }
    }
}
