package com.rudevelopers.healthcare.api;

import com.rudevelopers.healthcare.dto.request.RequestDoctorDto;
import com.rudevelopers.healthcare.service.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public String createDoctor(@RequestBody RequestDoctorDto doctorDto){

        doctorService.createDoctor(doctorDto);
        return doctorDto.getName();
    }


    @GetMapping("/{id}")
    public String findDoctor(@PathVariable String id){
        return id+"";
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable String id){
        return id+"";
    }

    @PutMapping(params="id")
    public String updateDoctor(
            @RequestParam String id,
            @RequestBody RequestDoctorDto doctorDto
    ){
        return doctorDto.toString();
    }

    @GetMapping(path="/list",params={
            "searchText",
            "page",
            "size"
    })
    public String findAllDoctor(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return "findAllDoctor";
    }
}
