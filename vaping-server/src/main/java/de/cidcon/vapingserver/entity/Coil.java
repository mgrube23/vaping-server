package de.cidcon.vapingserver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.cidcon.vapingserver.type.Material;
import de.cidcon.vapingserver.type.Metal;

@Entity
@Table(indexes = { @Index(name = "IDX_NAME", columnList = "name"),
		@Index(name = "IDX_MATERIAL", columnList = "material"),
		@Index(name = "IDX_METAL", columnList = "metal") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = "name") })
public class Coil {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private Float ohms;

	@NotNull
	private Material material;

	@NotNull
	private Metal metal;

	@JsonIgnore
	@ManyToOne
	@NotNull
	private Tank tank;

	public Coil(String name, Float ohms, Material material, Metal metal, Tank tank) {
		this.name = name;
		this.ohms = ohms;
		this.material = material;
		this.metal = metal;
		this.tank = tank;
	}

	Coil() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getOhms() {
		return ohms;
	}

	public Material getMaterial() {
		return material;
	}

	public Metal getMetal() {
		return metal;
	}

	public Tank getTank() {
		return tank;
	}

}
