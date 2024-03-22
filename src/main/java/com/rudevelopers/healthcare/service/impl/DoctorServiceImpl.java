package com.rudevelopers.healthcare.service.impl;

import com.rudevelopers.healthcare.dto.request.RequestDoctorDto;
import com.rudevelopers.healthcare.dto.response.ResponseDoctorDto;
import com.rudevelopers.healthcare.entity.Doctor;
import com.rudevelopers.healthcare.repo.DoctorRepo;
import com.rudevelopers.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;

    @Autowired //to inject this

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public void createDoctor(RequestDoctorDto dto) {

        UUID uuid= UUID.randomUUID();
        long docId= uuid.getMostSignificantBits();
       Doctor doctor=new Doctor(
         docId, dto.getName(), dto.getAddress(),dto.getContact(),dto.getSalary()
       );
        doctorRepo.save(doctor);
    }

    @Override
    public ResponseDoctorDto findDoctor(long id) {
        return null;
    }

    @Override
    public void deleteDoctor(long id) {

    }

    @Override
    public void updateDoctor(long id) {

    }

    @Override
    public List<ResponseDoctorDto> findAllDoctors(String searchText, int pageNo, int size) {
        return null;
    }
}
