package org.example;

import org.example.manytomany.Author;
import org.example.manytomany.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EntityManagerMainClass {

    public static void main(String[] args) {


//        ktijojme objektin EntityManager qe na sherben per te ber veprime ne DB
        EntityManager entityManager = App.sessionFactory.createEntityManager();

//        ktu fillojme transaction
        entityManager.getTransaction().begin();

//        lexojme nga DB autorin me ane te ids
        Author author = entityManager.find(Author.class, 2L);

//        krijojme nje liber te ri
        Book book = new Book();
        book.setBookTitle("Martin S. Biography book");

//        ruajme Librin e ri ne tabelen liber
        Book merge = entityManager.merge(book);

//        e shtojme librin e ri tek autori qe morem me ane te ids
        author.getBooks().add(merge);

        entityManager.getTransaction().commit();


        entityManager.close();
        System.out.println(author.toString());
    }

    private static void addNewBookToAnAuthor(Author author){
        Book book = new Book();
        book.setBookTitle("New Book From Martin S.");
        author.getBooks().add(book);
    }

}
