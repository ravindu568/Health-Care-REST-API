package com.rudevelopers.healthcare.repo;

import com.rudevelopers.healthcare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface DoctorRepo extends JpaRepository<Doctor,Long> {

public List<Doctor> findAllByName(String name);
@Query(value = "SELECT * FROM doctor WHERE name LIKE ?1 OR ADDRESS LIKE ?1",nativeQuery = true)
public List<Doctor> searchDoctors(String searchText, Pageable pageable);
@Query(value = "SELECT COUNT(*) FROM doctor WHERE name LIKE ?1 OR ADDRESS LIKE ?1",nativeQuery = true)
public Long countDoctors(String searchText);


}
