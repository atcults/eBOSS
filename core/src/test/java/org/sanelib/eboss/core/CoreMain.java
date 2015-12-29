package org.sanelib.eboss.core;

import org.sanelib.eboss.common.utils.Clock;
import org.sanelib.eboss.common.utils.CustomClock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoreMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CoreMain.class, args);
	}

    @Bean
    public Clock clock() {
        return new CustomClock();
    }

}
