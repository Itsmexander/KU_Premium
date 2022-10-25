package cwp.ntkt.kupremium.model;

import java.util.UUID;

public class employee {

    private UUID POID;

    private String name;
    private String surname;
    private String telNo;
    private String employeeRank;

    public employee(UUID POID, String name, String surname, String telNo, String employeeRank) {
        this.POID = POID;
        this.name = name;
        this.surname = surname;
        this.telNo = telNo;
        this.employeeRank = employeeRank;
    }

    public UUID getPOID() {
        return POID;
    }

    public void setPOID(UUID POID) {
        this.POID = POID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmployeeRank() {
        return employeeRank;
    }

    public void setEmployeeRank(String employeeRank) {
        this.employeeRank = employeeRank;
    }
}
