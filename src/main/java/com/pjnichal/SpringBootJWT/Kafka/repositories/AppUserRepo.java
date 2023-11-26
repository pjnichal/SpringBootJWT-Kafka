package com.pjnichal.SpringBootJWT.Kafka.repositories;

import com.pjnichal.SpringBootJWT.Kafka.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser,Integer> {

     Optional<AppUser> findByEmail(String email);


}
