package cwp.ntkt.kupremium.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;


public class FoodTraceabilityEmbedVideoList {

    public ArrayList<FoodTraceabilityEmbedVideo> foodTraceabilityEmbedVideoList;

    public FoodTraceabilityEmbedVideoList() {
        foodTraceabilityEmbedVideoList = new ArrayList<>();
    }

    public void addList(FoodTraceabilityEmbedVideo foodTraceabilityEmbedVideo){foodTraceabilityEmbedVideoList.add(foodTraceabilityEmbedVideo);}
}
