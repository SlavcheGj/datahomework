package com.endava.datahomework.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameOfOwner;

    private String ssn;

    @ManyToMany(mappedBy = "owners", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Car> cars;

    public Owner(){}

    public Owner(String nameOfOwner, String ssn ) {
        this.nameOfOwner = nameOfOwner;
        this.ssn = ssn;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
