package com.demo.learningspring;

import com.demo.learningspring.data.entity.Guest;
import com.demo.learningspring.data.entity.Reservation;
import com.demo.learningspring.data.entity.Room;
import com.demo.learningspring.data.repository.GuestRepository;
import com.demo.learningspring.data.repository.ReservationRepository;
import com.demo.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearningSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringApplication.class, args);
    }

    @RestController
    @RequestMapping("/rooms")
    public class RoomController {
        @Autowired
        private RoomRepository roomRepository;

        @GetMapping
        public Iterable<Room> getRooms() {
            return this.roomRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/guests")
    public class GuestController {
        @Autowired
        private GuestRepository repository;

        @GetMapping
        public Iterable<Guest> getGuests() {
            return this.repository.findAll();
        }
    }

    @RestController
    @RequestMapping("/reservations")
    public class ReservationController {
        @Autowired
        private ReservationRepository repository;

        @GetMapping
        public Iterable<Reservation> getReservations() {
            return this.repository.findAll();
        }
    }

}
