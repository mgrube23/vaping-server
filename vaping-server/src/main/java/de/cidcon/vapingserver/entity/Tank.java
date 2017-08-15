package de.cidcon.vapingserver.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(indexes = { @Index(name = "IDX_NAME", columnList = "name"),
		@Index(name = "IDX_CAPACITY", columnList = "capacity") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = "name") })
public class Tank {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private Float height;

	@NotNull
	private Float width;

	@NotNull
	private Float capacity;

	@ManyToOne
	@NotNull
	private Brand brand;

	@OneToMany(mappedBy = "tank")
	private Set<Coil> coils;

	public Tank(String name, Float height, Float width, Float capacity, Brand brand) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.capacity = capacity;
		this.brand = brand;
	}

	Tank() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getHeight() {
		return height;
	}

	public Float getWidth() {
		return width;
	}

	public Float getCapacity() {
		return capacity;
	}

	public Brand getBrand() {
		return brand;
	}

	public Set<Coil> getCoils() {
		return coils;
	}

}
