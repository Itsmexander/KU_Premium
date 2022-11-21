package cwp.ntkt.kupremium.model;

import cwp.ntkt.kupremium.service.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Customer list")
public class Customer {
    // TODO: 20/11/2565 เชื่อม databaase ให้ครบ
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    @GenericGenerator(
            name = "user_seq",
            strategy = "cwp.ntkt.kupremium.service.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "C"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(name = "Customer_ID")
    private String CustomerID;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "First name")
    private String firstName;
    @Column(name = "Last name")
    private String lastName;
    @Column(name = "Telephone number")
    private String telNo;
    @Column(name = "E-mail address")
    private String email;
    @Column(name = "Address")
    private String address;
}
