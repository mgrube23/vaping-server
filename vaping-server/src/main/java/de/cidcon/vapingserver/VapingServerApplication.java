package de.cidcon.vapingserver;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.cidcon.vapingserver.entity.Brand;
import de.cidcon.vapingserver.entity.Coil;
import de.cidcon.vapingserver.entity.Tank;
import de.cidcon.vapingserver.repository.BrandRepository;
import de.cidcon.vapingserver.repository.CoilRepository;
import de.cidcon.vapingserver.repository.TankRepository;
import de.cidcon.vapingserver.type.Material;
import de.cidcon.vapingserver.type.Metal;

@SpringBootApplication
public class VapingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VapingServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(TankRepository tankRepository, BrandRepository brandRepository,
			CoilRepository coilRepository) {
		return (evt) -> Arrays.asList("Joyetech,SMOK".split(",")).forEach(a -> {
			Brand brand = brandRepository.save(new Brand(a));
			Tank tank = tankRepository.save(new Tank("Tank " + a, new Float(4.1f), new Float(1.7f), new Float(4.0f), brand));
			coilRepository.save(new Coil("Coil " + a, new Float(0.5f), Material.Cotton, Metal.SS, tank));
		});
	}
}
