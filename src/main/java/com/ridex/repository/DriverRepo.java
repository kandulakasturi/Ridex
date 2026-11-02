package com.ridex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridex.entity.Driver;

public interface DriverRepo extends JpaRepository<Driver,Integer> {

}
