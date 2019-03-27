package com.example.Osoitemuistio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class OsoitemuistioApplication {
	private static final Logger log = LoggerFactory.getLogger(OsoitemuistioApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(OsoitemuistioApplication.class, args);
	}

	@Bean
	public CommandLineRunner yhteystietoDemo(YhteystietoRepository repository, UserRepository userrepo) {
		return (args) -> {
			log.info("näytä yhteystiedot");
			repository.save(new Yhteystieto("Nina", "Kovaljeff", "Ahvenanmaantie 5 B 7", "04430", "Järvenpää", "050 5793021"));
			repository.save(new Yhteystieto("Roope", "Ankka", "Rahasäiliö 1", "31300", "Ankkalinna", "030 3131313"));
			repository.save(new Yhteystieto("Bruno", "Kissa", "sohvan nurkka", "04430", "Järvenpää", "040 2468086"));
			
			userrepo.save(new User("Testi", "$2a$10$WusUzQkNcDy7T9L1t6UJFOmrd38v9UoVaoFr5oHEWcC0Ncd2yrBqO", "USER"));
			userrepo.save(new User("Nina", "$2a$10$rS8u/kLcf5.wbOFJDbjoJus08noR5mRzO9fgPq2RyFrHRKHP6aCJ.", "ADMIN"));
			userrepo.save(new User("Minna", "$2a$10$KU82RW4FAb.Wwhk4mUWHsepb62P2Yep4A1./ifo/I/fSi2cdSj0Ae", "ADMIN"));
			
			log.info("hae yhteystiedot");
			for (Yhteystieto yhteystieto : repository.findAll()) {
				log.info(yhteystieto.toString());
			}

		};
	}
}
