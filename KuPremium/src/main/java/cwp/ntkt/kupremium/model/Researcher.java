package cwp.ntkt.kupremium.model;

import java.util.UUID;

public class Researcher {

    private UUID POID;

    private String name;
    private String surname;
    private String telNo;
    private String researcherRank;


    public Researcher(UUID POID, String name, String surname, String telNo, String companyName, String companyAddress) {
        this.POID = POID;
        this.name = name;
        this.surname = surname;
        this.telNo = telNo;
        this.researcherRank =researcherRank;
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

    public String getResearcherRank() {
        return researcherRank;
    }

    public void setResearcherRank(String researcherRank) {
        this.researcherRank = researcherRank;
    }
}
