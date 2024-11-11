package roomBook.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roomBook.backend.reqmodels.ReqUser;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "grade")
    private Integer grade;

    static public User mapUser(ReqUser reqUser) {
        User user = new User();
        user.setName(reqUser.getName());
        user.setGrade(reqUser.getGrade());
        return user;
    }
}
