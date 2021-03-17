package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Это объект доступа к даным
//JpaRepository это нтефейс встроенный в инфраструктуру Spring Data JPA
public interface UserRepository extends JpaRepository<User, Long> {
    //Пишем для класса security->details->UserDetailsServiceImpl
    User findByEmail(String email);
}
