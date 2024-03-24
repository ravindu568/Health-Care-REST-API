package com.rudevelopers.healthcare.dto.response;

import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDoctorDto {
    @Id
    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
