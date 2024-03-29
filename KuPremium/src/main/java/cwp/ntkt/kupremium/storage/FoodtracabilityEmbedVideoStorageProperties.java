package cwp.ntkt.kupremium.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("ftev-storage")
public class FoodtracabilityEmbedVideoStorageProperties {

	private String location = "../KU_Premium/Food_Traceability_Embed_Video";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
