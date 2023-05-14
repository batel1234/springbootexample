package com.javatpoint.service;

import com.javatpoint.model.Renting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentingRepository extends JpaRepository<Renting, Long> {
}
