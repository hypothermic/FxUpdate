package nl.hypothermic.fxupdate;

import java.io.File;

import nl.hypothermic.fxupdate.ConfigUtil.Config;

public class Main {
	
	public static void main(String[] args) throws Exception {
		ConfigUtil.writeToFile(new File("src/main/resources/sample.xmlc"), new Config("MySampleApp", "v69.0.0"));
		Config cfg = ConfigUtil.readFromFile(new File("src/main/resources/sample.xmlc"));
		System.out.println(cfg.appVer);
	}
}
