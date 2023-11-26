package com.pjnichal.SpringBootJWT.Kafka.exceptions;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserAlreadyExists extends RuntimeException {
    private String message;
}
