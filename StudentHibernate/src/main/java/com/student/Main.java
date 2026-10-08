package com.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Student student = new Student(
                "Harini",
                "harini@gmail.com",
                "B.Tech IT"
        );

        session.persist(student);
        
     // Update the course
        student.setCourse("B.Tech Information Technology");

        session.merge(student);
        transaction.commit();

        session.close();
        factory.close();

        System.out.println("Student inserted successfully!");
    }
}