package com.rudevelopers.healthcare.service.impl;

import com.rudevelopers.healthcare.dto.request.RequestDoctorDto;
import com.rudevelopers.healthcare.dto.response.ResponseDoctorDto;
import com.rudevelopers.healthcare.dto.response.paginated.PaginatedDoctorResponseDto;
import com.rudevelopers.healthcare.entity.Doctor;
import com.rudevelopers.healthcare.exceptions.EntryNotFoundException;
import com.rudevelopers.healthcare.repo.DoctorRepo;
import com.rudevelopers.healthcare.service.DoctorService;
import com.rudevelopers.healthcare.utill.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;
    private final DoctorMapper doctorMapper;

    @Autowired //to inject this

    public DoctorServiceImpl(DoctorRepo doctorRepo, DoctorMapper doctorMapper) {
        this.doctorRepo = doctorRepo;
        this.doctorMapper = doctorMapper;
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

        Optional<Doctor> selectedDoctor=doctorRepo.findById(id);
        if(selectedDoctor.isEmpty()){
            throw new EntryNotFoundException("Doctor not found");
        }
//        Doctor doc=selectedDoctor.get();
//        return new ResponseDoctorDto(
//            doc.getId(),doc.getName(),doc.getAddress(),doc.getContact(),doc.getSalary()
//        );
        return doctorMapper.toResponseDoctorDto(selectedDoctor.get());

    }

    @Override
    public void deleteDoctor(long id) {
        Optional<Doctor> selectedDoctor=doctorRepo.findById(id);
        if(selectedDoctor.isEmpty()){
            throw new EntryNotFoundException("Doctor not found");        }
        doctorRepo.deleteById(selectedDoctor.get().getId());
    }

    @Override
    public List<ResponseDoctorDto> findDoctorByName(String name) {
        List<Doctor> allByName = doctorRepo.findAllByName(name);
        return null;
    }

    @Override
    public void updateDoctor(long id,RequestDoctorDto dto) {
        Optional<Doctor> selectedDoctor=doctorRepo.findById(id);
        if(selectedDoctor.isEmpty()){
            throw new EntryNotFoundException("Doctor not found");
        }
        Doctor doc=selectedDoctor.get();
        doc.setName(dto.getName());
        doc.setAddress(dto.getAddress());
        doc.setContact(dto.getContact());
        doc.setSalary(dto.getSalary());
        doctorRepo.save(doc);
    }

    @Override
    public PaginatedDoctorResponseDto findAllDoctors(String searchText, int pageNo, int size) {

        searchText="%"+searchText+"%";
        List<Doctor> doctors = doctorRepo.searchDoctors(searchText, (Pageable) PageRequest.of(pageNo, size));
        long doctorCount = doctorRepo.countDoctors(searchText);
//        List<ResponseDoctorDto> dtos=new ArrayList<>();
//        doctors.forEach(doc -> {
//            dtos.add(
//                    new ResponseDoctorDto(
//                            doc.getId(),doc.getName(),doc.getAddress(),doc.getContact(),doc.getSalary()
//                    )
//            );
//                }
//
//        );
        List<ResponseDoctorDto> dtos=doctorMapper.toResponseDoctorDtoList(doctors);
        return new PaginatedDoctorResponseDto(
                doctorCount,
                dtos

        );
    }
}
