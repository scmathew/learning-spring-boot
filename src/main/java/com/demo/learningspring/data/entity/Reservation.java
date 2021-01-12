package com.demo.learningspring.data.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="RESERVATION")
@Getter
@Setter
public class Reservation {
    @Id
    @Column(name="RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;

    @Column(name="ROOM_ID")
    private long roomId;

    @Column(name="GUEST_ID")
    private long guestId;

    @Column(name="RES_DATE")
    private Date reservationDate;
    
}
