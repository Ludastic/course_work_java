package roomBook.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import roomBook.backend.entities.Reservation;
import roomBook.backend.entities.Room;
import roomBook.backend.reqmodels.ReqReservation;
import roomBook.backend.services.ReservationService;
import roomBook.backend.services.RoomService;
import roomBook.backend.services.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ResponseBody
    public List<Room> getAllRooms() {
        return roomService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getById(id);
    }

    @GetMapping("/{id}/schedule")
    @ResponseBody
    public List<Reservation> getReservationsByRoomId(@PathVariable Long id) {
        return roomService.getRoomSchedule(id);
    }

    @PostMapping("/{id}/book")
    @ResponseBody
    public String bookRoom(@PathVariable Long id,
                           @RequestBody LocalDateTime startAt,
                           @RequestBody LocalDateTime endAt,
                           @RequestBody Long userId) {

        reservationService.addReservation(
                new ReqReservation(userService.getUserById(userId),
                        startAt, endAt,
                        roomService.getById(id)));

        return "Succes";
    }

    @GetMapping("/availability")
    @ResponseBody
    public List<Room> getAvailableRooms(@RequestBody LocalDateTime startAt,
                                        @RequestBody LocalDateTime endAt) {
        return roomService.getAvaliableRooms(startAt, endAt);
    }

}
