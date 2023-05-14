package com.javatpoint.service;

import com.javatpoint.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    List<Apartment> findApartmentsByNameContains(String name);
}
