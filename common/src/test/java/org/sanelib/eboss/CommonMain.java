package org.sanelib.eboss;

import java.util.Locale;

import org.sanelib.eboss.common.properties.AppProperties;
import org.sanelib.eboss.common.properties.MapDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonMain implements CommandLineRunner {

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private MapDictionaryService mapDictionaryService;

	@Override
	public void run(String... args) {
		Locale.setDefault(new Locale(this.appProperties.getLocale()));
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CommonMain.class, args);
	}

}
