package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Register {

    @Id
    @GeneratedValue

    private String trackNum;
    private String pID;
    private LocalDateTime sentDate;
    private String rName;
    private String note;
    private String status;
}
