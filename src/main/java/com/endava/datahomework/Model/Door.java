package com.endava.datahomework.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

public class Door {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String side;

    private String type;

    @ManyToOne
    private Car car;

    public Door(){}
    public Door(String side, String type) {
        this.side = side;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
