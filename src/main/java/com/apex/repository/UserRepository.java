package com.apex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apex.jpa.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
