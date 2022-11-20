package cwp.ntkt.kupremium.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity

public class RatingReview {
    @Id
    private String pID;
    private String reviewID;
    private double stars;
    private String review;
}
