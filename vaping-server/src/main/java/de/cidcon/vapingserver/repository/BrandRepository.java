package de.cidcon.vapingserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.cidcon.vapingserver.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
	Optional<Brand> findByName(String name);
}
