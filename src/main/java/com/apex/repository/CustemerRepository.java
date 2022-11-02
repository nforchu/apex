package com.apex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apex.jpa.Customer;

@Repository
public interface CustemerRepository extends JpaRepository<Customer, Long>{

}
