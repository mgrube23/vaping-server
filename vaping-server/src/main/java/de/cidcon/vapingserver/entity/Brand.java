package de.cidcon.vapingserver.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(indexes = { @Index(name = "IDX_NAME", columnList = "name") }, uniqueConstraints = {
		@UniqueConstraint(columnNames = "name") })
public class Brand {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "brand")
	private Set<Tank> tanks;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Tank> getTanks() {
		return tanks;
	}

	public Brand(String name) {
		this.name = name;
	}

	Brand() {
	}

}
