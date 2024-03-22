package com.rudevelopers.healthcare.service;

import com.rudevelopers.healthcare.dto.response.ResponseDoctorDto;

import java.util.List;

public interface DoctorService {

    public void createDoctor(ResponseDoctorDto dto);
    public ResponseDoctorDto findDoctor(long id);
    public void deleteDoctor(long id);
    public void updateDoctor(long id);
    public List<ResponseDoctorDto> findAllDoctors(String searchText,int pageNo,int size);
}
