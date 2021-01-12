package com.demo.learningspring.web;

import com.demo.learningspring.business.domain.RoomReservation;
import com.demo.learningspring.business.service.GuestService;
import com.demo.learningspring.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestsWebController {
    private final GuestService guestService;

    @Autowired
    public GuestsWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuests(Model model) {
        model.addAttribute("guests", this.guestService.getAllGuests());
        return "guests"; //Tells Thymeleaf to go find template named reservations and use the passed in model
    }
}
