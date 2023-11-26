package com.pjnichal.SpringBootJWT.Kafka.exceptions;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class UserNotFound extends RuntimeException{
    private String message;
}
