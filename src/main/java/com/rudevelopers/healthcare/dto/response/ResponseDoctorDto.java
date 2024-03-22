package com.rudevelopers.healthcare.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Data
public class ResponseDoctorDto {
    @Id
    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
