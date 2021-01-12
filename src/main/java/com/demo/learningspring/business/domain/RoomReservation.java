package com.demo.learningspring.business.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomReservation {
    private long roomId;
    private long guestId;
    private String roomName;
    private String roomNumber;
    private String firstName;
    private String lastName;
    private Date date;
}
