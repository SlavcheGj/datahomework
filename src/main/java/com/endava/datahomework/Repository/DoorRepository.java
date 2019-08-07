package com.endava.datahomework.Repository;

import com.endava.datahomework.Model.Door;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoorRepository extends JpaRepository<Door, Long> {
}
