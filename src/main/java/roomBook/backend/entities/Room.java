package roomBook.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import roomBook.backend.reqmodels.ReqRoom;

@Entity
@Setter
@Getter
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Room implements Comparable<Room>{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "with_tv")
    private Boolean with_tv;

    static public Room mapRoom(ReqRoom reqRoom) {
        Room room = new Room();
        room.setName(reqRoom.getName());
        room.setCapacity(reqRoom.getCapacity());
        room.setWith_tv(reqRoom.getWith_tv());
        return room;
    }
    public int compareTo(Room room) {
        return this.id.compareTo(room.getId());
    }
}
