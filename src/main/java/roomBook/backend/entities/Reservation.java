package roomBook.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roomBook.backend.reqmodels.ReqReservation;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Comparable<Reservation> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
    @Column(name = "started_at")
    private LocalDateTime startAt;
    @Column(name = "ended_at")
    private LocalDateTime EndAt;

    static public Reservation mapReservation(ReqReservation reqReservation) {
        Reservation reservation = new Reservation();
        reservation.setUser(reqReservation.getUser());
        reservation.setRoom(reqReservation.getRoom());
        reservation.setStartAt(reqReservation.getStartAt());
        reservation.setEndAt(reqReservation.getEndAt());
        return reservation;
    }
    @Override
    public int compareTo(Reservation o) {
        return startAt.compareTo(o.startAt);
    }
}
