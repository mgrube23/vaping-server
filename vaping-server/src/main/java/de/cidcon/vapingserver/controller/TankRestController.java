package de.cidcon.vapingserver.controller;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.cidcon.vapingserver.entity.Brand;
import de.cidcon.vapingserver.entity.Tank;
import de.cidcon.vapingserver.exception.BrandNotFoundException;
import de.cidcon.vapingserver.exception.TankNotFoundException;
import de.cidcon.vapingserver.repository.BrandRepository;
import de.cidcon.vapingserver.repository.TankRepository;

@RestController
@RequestMapping(path = "/tanks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TankRestController {

	@Autowired
	private TankRepository tankRepository;

	@Autowired
	private BrandRepository brandRepository;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Tank> readAllTanks() {
		return tankRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, params = "brand")
	public Collection<Tank> readTanksByBrand(@RequestParam(name = "brand", required = false) String brandName) {
		Brand brand = getBrand(brandName);
		Set<Tank> tanks = tankRepository.findByBrand(brand);
		if (tanks.isEmpty()) {
			throw new TankNotFoundException(brandName);
		}
		return tanks;
	}

	@RequestMapping(method = RequestMethod.GET, params = "name")
	public Collection<Tank> readTanksByName(@RequestParam(name = "name", required = false) String name) {
		Tank tank = tankRepository.findByName(name).orElseThrow(() -> new TankNotFoundException(name));
		return Stream.of(tank).collect(Collectors.toSet());
	}

	@RequestMapping(method = RequestMethod.GET, params = { "brand", "name" })
	public Collection<Tank> readTanksByBrandAndName(@RequestParam(name = "brand", required = false) String brandName,
			@RequestParam(name = "name", required = false) String name) {
		Brand brand = getBrand(brandName);
		Set<Tank> tanks = tankRepository.findByBrandAndName(brand, name);
		if (tanks.isEmpty()) {
			throw new TankNotFoundException(brandName, name);
		}
		return tanks;
	}

	private Brand getBrand(String brandName) throws BrandNotFoundException {
		return brandRepository.findByName(brandName).orElseThrow(() -> new BrandNotFoundException(brandName));
	}

}
