package roomBook.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roomBook.backend.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
