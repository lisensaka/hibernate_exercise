package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "school_table")
@Getter @Setter
public class School extends BaseClass{

    private String schoolName;

    @OneToOne
    private City city;

    @OneToOne(mappedBy = "school")
    private Student student;

}
