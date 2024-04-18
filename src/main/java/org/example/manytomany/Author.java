package org.example.manytomany;

import lombok.Getter;
import lombok.Setter;
import org.example.BaseClass;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Author extends BaseClass {

    private String authorName;

    @ManyToMany
    private List<Book> books;

    public Author() {
        books = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
//                ", books=" + books +
                '}';
    }
}
