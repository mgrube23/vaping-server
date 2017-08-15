package de.cidcon.vapingserver.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import de.cidcon.vapingserver.entity.Coil;
import de.cidcon.vapingserver.type.Material;
import de.cidcon.vapingserver.type.Metal;

public interface CoilRepository extends JpaRepository<Coil, Long> {
	Optional<Coil> findByName(String name);

	Set<Coil> findByMaterial(Material material);

	Set<Coil> findByMetal(Metal metal);
}
