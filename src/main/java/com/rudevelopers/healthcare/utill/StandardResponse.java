package com.rudevelopers.healthcare.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardResponse {

    private int code;
    private String message;
    private Object data;

}
