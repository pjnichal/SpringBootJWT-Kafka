package com.pjnichal.SpringBootJWT.Kafka.globalexceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {

    private int statusCode;
    private String message;

}