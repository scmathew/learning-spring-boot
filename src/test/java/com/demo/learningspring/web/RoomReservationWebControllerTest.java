package com.demo.learningspring.web;

import com.demo.learningspring.business.domain.RoomReservation;
import com.demo.learningspring.business.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationWebController.class)
public class RoomReservationWebControllerTest {
    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception {
        String dateString = "2020-01-01";
        Date date = DateUtils.createDateFromDateString(dateString);
        RoomReservation roomReservation = RoomReservation.builder()
                .lastName("Unit")
                .firstName("JUnit")
                .date(date)
                .guestId(1)
                .roomId(100)
                .roomName("JUnit Room")
                .roomNumber("J1")
                .build();
        given(reservationService.getRoomReservationsForDate(date)).willReturn(Collections.singletonList(roomReservation));

        this.mockMvc.perform(get("/reservations/date=" + dateString))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Unit, JUnit")));
    }
}
