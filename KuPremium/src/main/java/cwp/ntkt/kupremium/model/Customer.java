package cwp.ntkt.kupremium.model;

import cwp.ntkt.kupremium.service.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    // TODO: 20/11/2565 เชื่อม database ให้ครบ
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cus_seq")
    @GenericGenerator(
            name = "cus_seq",
            strategy = "cwp.ntkt.kupremium.service.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "C"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
//    @Column(name = "Customer_ID")
    private String CustomerID;
//    @Column(name = "Username")
    private String username;
//    @Column(name = "Password")
    private String password;
//    @Column(name = "First name")
    private String firstName;
//    @Column(name = "Last name")
    private String lastName;
//    @Column(name = "Telephone number")
    private String telNo;
//    @Column(name = "E-mail address")
    private String email;
//    @Column(name = "Address")
    private String address;
    private final String role = "Customer";

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }
}
