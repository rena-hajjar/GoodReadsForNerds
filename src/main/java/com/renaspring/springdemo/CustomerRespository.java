package com.renaspring.springdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository<Customer, Integer> {

}
