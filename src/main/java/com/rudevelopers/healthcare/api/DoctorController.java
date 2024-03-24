package com.rudevelopers.healthcare.api;

import com.rudevelopers.healthcare.dto.request.RequestDoctorDto;
import com.rudevelopers.healthcare.service.DoctorService;
import com.rudevelopers.healthcare.utill.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createDoctor(@RequestBody RequestDoctorDto doctorDto){

        doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"doctor was saved!",doctorDto.getName()), HttpStatus.CREATED
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findDoctor(@PathVariable long id){


        return new ResponseEntity<>(
                new StandardResponse(200,"your doctor is:",doctorService.findDoctor(id)), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"data was deleted!",doctorService.findDoctor(id)), HttpStatus.NO_CONTENT
        );
    }

    @PutMapping(params="id")
    public ResponseEntity<StandardResponse> updateDoctor(
            @RequestParam long id,
            @RequestBody RequestDoctorDto doctorDto
    ){
        doctorService.updateDoctor(id,doctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"record has ben updated",doctorDto.getName()), HttpStatus.CREATED
        );
    }

    @GetMapping(path="/list",params={
            "searchText",
            "page",
            "size"
    })
    public ResponseEntity<StandardResponse> findAllDoctor(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(200,"doctor list",doctorService.findAllDoctors(
                        searchText, page, size)), HttpStatus.OK
        );
    }
}
