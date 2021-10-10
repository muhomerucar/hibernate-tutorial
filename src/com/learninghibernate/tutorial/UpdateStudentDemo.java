package com.learninghibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            // let's update emails
            session.createQuery("update Student set email = 'fastandfurious@forthefamily.com' where firstName='Dominic'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Update has been done!");



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            factory.close();
        }
    }
}
