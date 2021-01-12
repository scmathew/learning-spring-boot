package com.demo.learningspring.business.service;

import com.demo.learningspring.business.domain.RoomReservation;
import com.demo.learningspring.data.entity.Guest;
import com.demo.learningspring.data.entity.Reservation;
import com.demo.learningspring.data.entity.Room;
import com.demo.learningspring.data.repository.GuestRepository;
import com.demo.learningspring.data.repository.ReservationRepository;
import com.demo.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    // not required since there is only 1 constructor. but is more specific
    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    // code taken directly from the course, could be optimized
    public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();

        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setGuestId(guest.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        return new ArrayList<>(roomReservationMap.values());
    }
}
