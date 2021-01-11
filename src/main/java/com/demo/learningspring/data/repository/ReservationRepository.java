package com.demo.learningspring.data.repository;

import com.demo.learningspring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
