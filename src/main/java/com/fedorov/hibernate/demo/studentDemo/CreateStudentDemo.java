package com.fedorov.hibernate.demo.studentDemo;

import com.fedorov.hibernate.demo.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {

        //create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate_student.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {
            //use the session object to save Java object

            //create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("John2", "Rambo2", "msg2unk2@gmail.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

//            another way to insert my Stunent in table:


            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }
}







