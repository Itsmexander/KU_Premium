package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


public class ProductPic{

    private UUID uuid;

    private String pID;
    private String picID;
    private String pictureFilePath;

    public ProductPic(UUID uuid, String pID, String picID, String pictureFilePath) {
        this.uuid = uuid;
        this.pID = pID;
        this.picID = picID;
        this.pictureFilePath = pictureFilePath;
    }
}
