package com.demo.learningspring.data.repository;

import com.demo.learningspring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Iterable<Reservation> findReservationByReservationDate(Date date);
}
