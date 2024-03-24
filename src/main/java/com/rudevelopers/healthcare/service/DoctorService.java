package com.rudevelopers.healthcare.service;

import com.rudevelopers.healthcare.dto.request.RequestDoctorDto;
import com.rudevelopers.healthcare.dto.response.ResponseDoctorDto;
import com.rudevelopers.healthcare.dto.response.paginated.PaginatedDoctorResponseDto;

import java.util.List;

public interface DoctorService {

    public void createDoctor(RequestDoctorDto dto);
    public ResponseDoctorDto findDoctor(long id);
    public void deleteDoctor(long id);
    public List<ResponseDoctorDto> findDoctorByName(String name);


    void updateDoctor(long id, RequestDoctorDto dto);

    public PaginatedDoctorResponseDto findAllDoctors(String searchText, int pageNo, int size);
}
