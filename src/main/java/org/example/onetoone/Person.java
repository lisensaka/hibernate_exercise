package org.example.onetoone;

import lombok.Getter;
import lombok.Setter;
import org.example.BaseClass;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter @Setter
public class Person extends BaseClass{

    private String fullName;


//    private Passport passport;

}
