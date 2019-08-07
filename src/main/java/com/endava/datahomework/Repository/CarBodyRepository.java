package com.endava.datahomework.Repository;

import com.endava.datahomework.Model.CarBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBodyRepository extends JpaRepository<CarBody,Long> {
}
