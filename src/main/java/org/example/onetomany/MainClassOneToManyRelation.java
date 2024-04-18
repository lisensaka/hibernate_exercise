package org.example.onetomany;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import static org.example.App.sessionFactory;

public class MainClassOneToManyRelation {
    public static void main(String[] args) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

//            krijojme nje liste me student
            Student johnDoe = new Student("John Doe");
            Student steveMurphy = new Student("Steve Murphy");
            Student alexSteph = new Student("Alex Steph");
            Student jordan_peterson = new Student("Jordan Peterson");
            Student peterDijk = new Student("Peter Dijk");


//            krijojme nje shkoll
            School andGetSchool = createAndGetSchool();

//            shtojme shkollen tek studentet
            johnDoe.setSchool(andGetSchool);
            steveMurphy.setSchool(andGetSchool);
            alexSteph.setSchool(andGetSchool);
            jordan_peterson.setSchool(andGetSchool);
            peterDijk.setSchool(andGetSchool);

//            ruajme studented dhe shkollen ne db
            session.save(andGetSchool);

            session.save(johnDoe);
            session.save(steveMurphy);
            session.save(alexSteph);
            session.save(jordan_peterson);
            session.save(peterDijk);

            transaction.commit();

        }
    }

    private static School createAndGetSchool() {
        School school = new School();
        school.setSchoolName("Kristaq Capo");
        return school;
    }

}
