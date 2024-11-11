package roomBook.backend.reqmodels;


import jakarta.persistence.Column;
import lombok.*;
import roomBook.backend.entities.Room;
import roomBook.backend.entities.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqReservation {
    private User user;
    private LocalDateTime startAt;
    private LocalDateTime EndAt;
    private Room room;


}
