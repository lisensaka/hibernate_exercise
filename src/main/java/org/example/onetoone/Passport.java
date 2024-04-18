package org.example.onetoone;

import lombok.Getter;
import lombok.Setter;
import org.example.BaseClass;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pasaporte")
@Getter @Setter
public class Passport extends BaseClass {

    private String passportNumber;
    private LocalDate validDate;

    @OneToOne
    private Person person;

}
