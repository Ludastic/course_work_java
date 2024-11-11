package roomBook.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roomBook.backend.entities.Reservation;
import roomBook.backend.entities.Room;
import roomBook.backend.repositories.ReservationRepository;
import roomBook.backend.repositories.RoomRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReservationService reservationService;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room getById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Reservation> getRoomSchedule(Long id) {
        List<Reservation> allReservations = reservationService.getAllReservations();
        allReservations.removeIf(reservation -> !reservation.getId().equals(id));
        Collections.sort(allReservations);
        return allReservations;
    }

    public List<Room> getAvaliableRooms(LocalDateTime start, LocalDateTime end) {
        List<Room> rooms = roomRepository.findAll();
        List<Reservation> reservations = reservationService.getAllReservations();
        Collections.sort(rooms);
        for (Reservation reservation : reservations) {
            if (!(start.isAfter(reservation.getEndAt()) && end.isBefore(reservation.getStartAt()))) {
                rooms.remove(reservation.getRoom());
            }
        }
        return rooms;
    }
}
