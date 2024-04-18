package org.example.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

import static org.example.App.sessionFactory;

public class MainAppOneToOneRelation {

    public static void main(String[] args) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

//            ktu po krijojme nje Person
            Person person = saveAndReturnPerson();

//            ktu po krijojme nje Pasaporte
            Passport passport = savePassport(person);

//            ktu po vendosim Personin qe i perket Pasaporta
            passport.setPerson(person);

//            ktu po ruajme Personin dhe Pasaporten ne DB
            session.save(person);
            session.save(passport);

            transaction.commit();
        }
    }

    private static Passport savePassport(Person person) {
        Passport passport = new Passport();
        passport.setPassportNumber("AA132456");
        passport.setValidDate(LocalDate.of(2026, 7, 13));
        passport.setPerson(person);
        return passport;
    }

    private static Person saveAndReturnPerson() {
        Person person = new Person();
        person.setFullName("John Dow");
        return person;
    }
}
