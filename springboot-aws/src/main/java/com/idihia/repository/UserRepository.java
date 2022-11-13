package com.idihia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idihia.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
