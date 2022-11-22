package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;



public class FoodTraceabilityEmbedVideo {

    private UUID uuid;
    private String pID;
    private String foodTraceVidID;
    private String foodTraceFilePath;
}
