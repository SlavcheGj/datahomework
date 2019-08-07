package com.endava.datahomework;

import com.endava.datahomework.Model.Car;
import com.endava.datahomework.Model.CarBody;
import com.endava.datahomework.Model.Door;
import com.endava.datahomework.Model.Owner;
import com.endava.datahomework.Repository.CarBodyRepository;
import com.endava.datahomework.Repository.CarRepository;
import com.endava.datahomework.Repository.DoorRepository;
import com.endava.datahomework.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.OneToMany;
import javax.transaction.TransactionScoped;
import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
public class DatahomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DatahomeworkApplication.class, args);
    }

    @Autowired
    CarRepository carRepository;
    @Autowired
    CarBodyRepository carBodyRepository;
    @Autowired
    DoorRepository doorRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //OneToOne
        Car zastava850 = new Car("Zastava850", new CarBody(908996L));
        carRepository.save(zastava850);

        System.out.println("This is the first car that i have driven in OneToOne Relatioship => " + carRepository.findById(1L).get().getName() + "\n");

        Car opelCorsa = new Car("Opel Corsa 1.3 CDT");
        opelCorsa.setCarBody(new CarBody(909636L));
        carRepository.save(opelCorsa);

        //OneToMany //ManyToOne
        List<Door> doors = new LinkedList<>();
        Door frontLeft = new Door("Front Left", "Conventional");
        Door frontRight = new Door("Front Right", "Conventional");
        frontLeft.setCar(zastava850);
        frontRight.setCar(zastava850);
        doorRepository.save(frontLeft);
        doorRepository.save(frontRight);
        doors.add(frontLeft);
        doors.add(frontRight);
        zastava850.setDoors(doors);
        carRepository.save(zastava850);

        System.out.println("It has oneToMany relationship with its dors.. => ");
        carRepository.findById(1L).get().getDoors().forEach(door -> System.out.println(door.getSide() + "\n"));


        //ManyToMany
        Set<Owner> ownersList = new HashSet<>();

        Owner ownerNumOne = new Owner("Slavko Gjorgjiev - Grandpa", "090877643");
        ownerRepository.save(ownerNumOne);

        Owner ownerNumTwo = new Owner("Slavche Gjorgjiev - Grandson", "094776423");
        ownerRepository.save(ownerNumTwo);

        ownersList.add(ownerNumOne);
        ownersList.add(ownerNumTwo);

        zastava850.setOwners(ownersList);
        carRepository.save(opelCorsa);


        Set<Car> carsList= new HashSet<>();
        carsList.add(zastava850);
        carsList.add(opelCorsa);
        ownerNumOne.setCars(carsList);
        ownerNumTwo.setCars(carsList);
        ownerRepository.save(ownerNumOne);
        ownerRepository.save(ownerNumTwo);

        System.out.println("But i was not the only owner of that car => ");
        carRepository.findById(zastava850.getId()).get().getOwners().stream().forEach(owner -> System.out.println(owner.getNameOfOwner()));
        System.out.println("And i am owner of these cars => ");
        ownerRepository.findById(ownerNumOne.getId()).get().getCars().stream().forEach(owner -> System.out.println(owner.getName()));
        

    }
}
