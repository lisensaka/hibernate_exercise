package org.example.onetomany;

import lombok.Getter;
import lombok.Setter;
import org.example.BaseClass;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Student extends BaseClass {

    private String studentFullName;

    @ManyToOne
    private School school;

    public Student(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public Student() {
    }
}
