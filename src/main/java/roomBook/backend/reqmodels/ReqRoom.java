package roomBook.backend.reqmodels;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqRoom {
    private String name;
    private Integer capacity;
    private Boolean with_tv;
}
