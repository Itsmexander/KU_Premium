package cwp.ntkt.kupremium.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;


public class AudioEmbedList{
    public ArrayList<AudioEmbed> audioEmbedList;

    public AudioEmbedList() {
        audioEmbedList = new ArrayList<>();
    }

    public void addList(AudioEmbed audioEmbed){audioEmbedList.add(audioEmbed);}
}
