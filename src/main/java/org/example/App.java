package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static void main(String[] args) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            long studentId = 2;

//           *** method for saving new Student with Hibernate
            saveStudent(session, "John", "Doe", 41);

//           ***  method for reading Student by id  Hibernate
//            getStudentById(session, studentId);


//           *** method for updating Student by id  Hibernate
//            Student studentById = getStudentById(session, studentId);
//            updateStudentById(studentById);

//           *** method for reading Student by id  Hibernate
//            readAllValuesInDb(session);

//           *** method for deleting Student by id  Hibernate
//            Student studentById = getStudentById(session, 1);
//            deleteStudent(session, studentById);

            transaction.commit();
        }

    }

    private static void deleteStudent(Session session, Student student) {
        if (student == null) {
            System.out.println("Student was not found!");
        }
        session.delete(student);
        System.out.println("Student was successfully deleted!");
    }

    private static void readAllValuesInDb(Session session) {
        List<Student> studentList = session.createQuery("from Student").list();
        studentList.forEach(System.out::println);
    }

    private static void updateStudentById(Student studentById) {
        studentById.setAge(20);
        studentById.setFirstName("Sda_firstName");
        studentById.setLastName("Sda_lastName");
    }

    private static Student getStudentById(Session session, long studentId) {
//        Student studentById = session.get(Student.class, studentId);
        Student studentById = (Student) session.createQuery("from Student where id = :studentId").setParameter("studentId", studentId).getSingleResult();

        if (studentById != null) {
            System.out.println("Student by id : " + studentById);
        } else {
            System.out.println("Student not found with id provided: " + studentId);
        }
        return studentById;
    }

    private static void saveStudent(Session session, String firstName, String lastName, int age) {
        City city = saveAndGetCity(session);

        School school = saveAndGetSchool(city, session);

        Student student = new Student(firstName, lastName, age);
        student.setSchool(school);
        session.save(student);
    }

    private static School saveAndGetSchool(City city, Session session) {
        School school = new School();
        school.setCity(city);
        school.setSchoolName("Kristaq Capo");
        session.save(school);
        return school;
    }

    private static City saveAndGetCity(Session session) {
        City city = new City();
        city.setCityName("Berat");
        session.save(city);
        return city;
    }


}
