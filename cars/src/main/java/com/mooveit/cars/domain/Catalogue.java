package com.mooveit.cars.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="catalogue")
public class Catalogue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catalogue_id")
	private Integer catalogueId;
	
	
	private String brandName = "FORD";
	
	@OneToMany( mappedBy = "catalogue")
	private List<Model> models;
	
	
	public Catalogue(List<Model> models) {
		if (Objects.isNull(models)) {
			this.models = new ArrayList<>();
		} else {
			this.models = models;
		}
	}

	@Override
	public String toString() {
		return "Catalogue{" + "models=" + models + '}';
	}
	
	
	
}
