package com.endava.datahomework.Repository;

import com.endava.datahomework.Model.Car;
import com.endava.datahomework.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

}
