package nl.hypothermic.fxupdate;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class ConfigUtil {

	public static Config readFromFile(File file) throws Exception {
		Config cfg = null;
		JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		cfg = (Config) jaxbUnmarshaller.unmarshal(file);
		return cfg;
	}

	public static void writeToFile(File file, Config cfg) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Config.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(cfg, file);
	}

	@XmlRootElement(name = "config")
	public static class Config {
		
		public Config() {
			;
		}
		
		public Config(final String appName, final String appVer) {
			this.appName = appName;
			this.appVer = appVer;
		}

		String appName;
		String appVer;

		public String getAppName() {
			return appName;
		}

		@XmlElement
		public void setAppName(String appName) {
			this.appName = appName;
		}
		
		public String getAppVer() {
			return appVer;
		}

		@XmlElement
		public void setAppVer(String appVer) {
			this.appVer = appVer;
		}
	}
}
