package roomBook.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roomBook.backend.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {}
