package org.example.manytomany;

import org.hibernate.Session;
import org.hibernate.Transaction;


import static org.example.App.sessionFactory;

public class MainAppManyToManyRelation {

    public static void main(String[] args) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Book hs = new Book();
            hs.setBookTitle("Historia e Skenderbeut");

            Author mb = new Author();
            mb.setAuthorName("Marin Barleti");
            mb.getBooks().add(hs);

            Author ms = new Author();
            ms.setAuthorName("Martin Segoni");
            ms.getBooks().add(hs);

            session.save(hs);
            session.save(mb);
            session.save(ms);

            transaction.commit();
        }

    }
}
