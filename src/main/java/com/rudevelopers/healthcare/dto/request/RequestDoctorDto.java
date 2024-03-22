package com.rudevelopers.healthcare.dto.request;

import com.rudevelopers.healthcare.dto.response.ResponseDoctorDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RequestDoctorDto{
    private String name;
    private String address;
    private String contact;
    private double salary;
}
