package com.tka.schoolservice.repositories;

import com.tka.schoolservice.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{

}
