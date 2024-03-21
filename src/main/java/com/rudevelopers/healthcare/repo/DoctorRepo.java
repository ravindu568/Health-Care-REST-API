package com.rudevelopers.healthcare.repo;

import com.rudevelopers.healthcare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {


}
