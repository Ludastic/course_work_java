package roomBook.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import roomBook.backend.entities.Reservation;
import roomBook.backend.entities.User;
import roomBook.backend.reqmodels.ReqUser;
import roomBook.backend.services.ReservationService;
import roomBook.backend.services.UserService;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{id}/bookings")
    @ResponseBody
    public List<Reservation> getBookings(@PathVariable Long id) {
        return reservationService.getAllReservationsByUserId(id);
    }

    @PostMapping("/create")
    @ResponseBody
    public String createUser(@RequestBody ReqUser reqUser) {
        userService.save(reqUser);
        return reqUser + "was succ added";
    }

    @DeleteMapping("/{id}/delete")
    @ResponseBody
    public String deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        userService.delete(id);
        return user + "was succ deleted";
    }
}
