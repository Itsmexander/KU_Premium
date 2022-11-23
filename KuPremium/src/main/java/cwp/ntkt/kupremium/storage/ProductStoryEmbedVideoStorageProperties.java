package cwp.ntkt.kupremium.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("psev-storage")
public class ProductStoryEmbedVideoStorageProperties {

	private String location = "../KU_Premium/Product_Story_Embed_Video";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
