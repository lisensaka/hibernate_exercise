package org.example.hqlqueries;

import org.example.App;
import org.example.manytomany.Author;
import org.example.manytomany.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class HqlQueryInAction {
    //        ktijojme objektin EntityManager qe na sherben per te ber veprime ne DB
    static EntityManager entityManager = App.sessionFactory.createEntityManager();

    public static void main(String[] args) {
//        readAllAuthorValues();
//        readAllBookValues();
//        getBookByTitle("Historia e Skenderbeut");
        getAllBooksByAuthorNameNativeQuery("Martin Segoni");
    }

    static void readAllAuthorValues() {
        List<Author> fromAuthor = entityManager.createQuery("from Author", Author.class).getResultList();
        for (Author a : fromAuthor) {
            System.out.println(a);
        }
    }

    static void readAllBookValues() {
        List<Book> fromBook = entityManager.createQuery("from Book as b order by b.bookTitle asc ", Book.class).getResultList();
        for (Book b : fromBook) {
            System.out.println(b);
        }
    }

    static void getAllBooksByAuthorNameNativeQuery(String authorName) {
        Query nativeQuery = entityManager.createNativeQuery("select * \n" +
                "from testdb.book b \n" +
                "inner join testdb.author_book ab on b.id = ab.books_id  \n" +
                "inner join testdb.author a on a.id = ab.Author_id \n" +
                "where a.authorName = :name " +
                "order by b.bookTitle asc ",
                Book.class)
                .setParameter("name", authorName );
        List<Book> resultList = nativeQuery.getResultList();
        for (Book b : resultList) {
            System.out.println(b);
        }
    }

    static void getBookByTitle(String bookTitle) {
        Query query = entityManager.createQuery("from Book as b where b.bookTitle = :title", Book.class);
        query.setParameter("title", bookTitle);
        List<Book> bookByTitle = (List<Book>) query.getResultList();

        for (Book bookb : bookByTitle) {
            System.out.println(bookb);
        }
    }
}
