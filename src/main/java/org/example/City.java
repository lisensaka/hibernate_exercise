package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city_table")
@Getter
@Setter
public class City extends BaseClass{

    private String cityName;

    @OneToOne(mappedBy = "city")
    private School school;
}
