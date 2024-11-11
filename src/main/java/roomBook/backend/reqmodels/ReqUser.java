package roomBook.backend.reqmodels;

import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqUser {
    private String name;
    private Integer grade;
}
