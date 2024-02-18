package com.vcakitchen.repository;

import com.vcakitchen.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository class that extends JpaRepository that help us to interact with the DATABASE through to Hibernate and its predefined methods;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

        }
