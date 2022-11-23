package cwp.ntkt.kupremium.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ea-storage")
public class EmbedAudioStorageProperties {

	private String location = "../KU_Premium/Embed_Audio_Embed_Video";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
