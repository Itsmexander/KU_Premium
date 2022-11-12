package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class testResult {

    @Id
    @GeneratedValue
    private String pID;
    private boolean fDA_356_Att;
    private boolean fDA_356_Res;
    private String fDA_356_Cer;
    private boolean fDA_414_Att;
    private boolean fDA_414_Res;
    private String fDA_414_Cer;
    private boolean fDA_416_Att;
    private boolean fDA_416_Res;
    private String fDA_416_Cer;
    private boolean fDA_418_Att;
    private boolean fDA_418_Res;
    private String fDA_418_Cer;
}
