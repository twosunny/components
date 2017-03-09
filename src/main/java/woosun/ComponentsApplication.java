package woosun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mitchellbosecke.pebble.PebbleEngine;

@SpringBootApplication
public class ComponentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentsApplication.class, args);
	}
	
	@Bean
    public PebbleEngine pebbleEngine() {
        return new PebbleEngine.Builder().cacheActive(false).build();
    }
}
