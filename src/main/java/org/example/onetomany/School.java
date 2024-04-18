package org.example.onetomany;

import lombok.Getter;
import lombok.Setter;
import org.example.BaseClass;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class School extends BaseClass {

    private String schoolName;

    @OneToMany(mappedBy = "school")
    private List<Student> studentList = new ArrayList<>();

}
