package com.ridex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridex.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

}
