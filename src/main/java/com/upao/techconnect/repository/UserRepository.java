package com.upao.techconnect.repository;

import com.upao.techconnect.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
