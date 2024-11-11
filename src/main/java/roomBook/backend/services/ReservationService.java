package roomBook.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roomBook.backend.entities.Reservation;
import roomBook.backend.entities.Room;
import roomBook.backend.repositories.ReservationRepository;
import roomBook.backend.reqmodels.ReqReservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(ReqReservation reqReservation) {
        Reservation reservation = Reservation.mapReservation(reqReservation);
        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation r : reservations) {
            if (!(reservation.getStartAt().isAfter(r.getEndAt()) || reservation.getEndAt().isBefore(r.getStartAt())) ) {
                return;
            }
        }
        reservationRepository.saveAndFlush(reservation);
    }

    public List<Reservation> getAllReservationsByUserId(Long userId) {
        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation r : reservations) {
            if (!r.getUser().getId().equals(userId)) {
                reservations.remove(r);
            }
        }
        return reservations;
    }

    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }


}
