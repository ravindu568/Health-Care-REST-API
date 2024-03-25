package com.rudevelopers.healthcare.dto.response.paginated;

import com.rudevelopers.healthcare.dto.response.ResponseDoctorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedDoctorResponseDto {

    private long count;
    private List<ResponseDoctorDto> dataList;
}
