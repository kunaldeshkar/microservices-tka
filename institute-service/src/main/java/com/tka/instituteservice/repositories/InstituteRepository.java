package com.tka.instituteservice.repositories;

import com.tka.instituteservice.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Integer>{

}
