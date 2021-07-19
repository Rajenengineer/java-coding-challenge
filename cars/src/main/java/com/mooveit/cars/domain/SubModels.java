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
@Entity(name = "sub_model")
public class SubModels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_model_id")
	private Integer subModelId;

	@OneToMany( mappedBy = "subModel")
	private List<Model> models;

	public SubModels(List<Model> models) {
		if (Objects.isNull(models)) {
			this.models = new ArrayList<>();
		} else {
			this.models = models;
		}
	}
}
