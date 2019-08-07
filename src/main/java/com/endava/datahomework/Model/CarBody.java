package com.endava.datahomework.Model;


import javax.persistence.*;

@Entity

public class CarBody {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long vin;

    @OneToOne(mappedBy = "carBody")
    private Car car;

    public CarBody(){}

    public CarBody(Long vin) {
        this.vin = vin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVin() {
        return vin;
    }

    public void setVin(Long vin) {
        this.vin = vin;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
