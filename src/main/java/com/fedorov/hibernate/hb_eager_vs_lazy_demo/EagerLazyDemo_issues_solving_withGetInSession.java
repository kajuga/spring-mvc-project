package com.fedorov.hibernate.hb_eager_vs_lazy_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo_issues_solving_withGetInSession {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate_instructor.cfg.xml")
                .addAnnotatedClass(Instructor_EL.class)
                .addAnnotatedClass(InstructorDetail_EL.class)
                .addAnnotatedClass(Course_EL.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();


            //get the instructor from db
            int theId = 3;
            Instructor_EL tempInstructor = session.get(Instructor_EL.class, theId);

            System.out.println("Fedorov2code: Instructor: " + tempInstructor);

            System.out.println("Fedorov2code: Courses: " + tempInstructor.getCourses());

            //commit transaction
            session.getTransaction().commit();

            //close the session
            session.close();
            System.out.println("Fedorov2code: The session now is closed!\n");

//          WARNING!!! if i try do this after session.close(), i caught exception!!
            System.out.println("Fedorov2code: Courses: " + tempInstructor.getCourses());


            System.out.println("Done!");
        }
        finally {
            //add clean up code
            session.close();
            factory.close();
        }
    }
}












