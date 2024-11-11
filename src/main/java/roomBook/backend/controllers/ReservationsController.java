package roomBook.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import roomBook.backend.entities.Reservation;
import roomBook.backend.entities.User;
import roomBook.backend.reqmodels.ReqReservation;
import roomBook.backend.services.ReservationService;
import roomBook.backend.services.RoomService;
import roomBook.backend.services.UserService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("reservation")
public class ReservationsController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;

    @PostMapping("/{room_id}/book")
    @ResponseBody
    public String bookRoom(@PathVariable Long room_id,
                           @RequestBody LocalDateTime startAt,
                           @RequestBody LocalDateTime endAt,
                           @RequestBody Long userId) {

        reservationService.addReservation(
                new ReqReservation(userService.getUserById(userId),
                        startAt, endAt,
                        roomService.getById(room_id)));

        return "Succes";
    }

    @DeleteMapping("/{book_id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long book_id) {
        Reservation reservation = reservationService.getReservationById(book_id);
        reservationService.deleteReservation(book_id);
        return reservation + "was successfully deleted";
    }
}
