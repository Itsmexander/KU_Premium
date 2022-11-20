package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity

public class RelatedResearch {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String pID;
    private String relatedResearchID;
    private String relatedResearchFilePath;
}
