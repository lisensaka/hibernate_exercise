package org.example.manytomany;

import lombok.Getter;
import lombok.Setter;
import org.example.BaseClass;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Book extends BaseClass {

    private String bookTitle;

//    @ManyToMany
//    private List<Author> authors;


    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
