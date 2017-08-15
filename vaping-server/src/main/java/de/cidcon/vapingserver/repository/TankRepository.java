package de.cidcon.vapingserver.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import de.cidcon.vapingserver.entity.Brand;
import de.cidcon.vapingserver.entity.Tank;

public interface TankRepository extends JpaRepository<Tank, Long> {
	Optional<Tank> findByName(String name);

	Set<Tank> findByCapacity(Float capacity);

	Set<Tank> findByCapacityGreaterThanEqual(Float capacity);

	Set<Tank> findByBrand(Brand brand);

	Set<Tank> findByBrandAndName(Brand brand, String name);
}
