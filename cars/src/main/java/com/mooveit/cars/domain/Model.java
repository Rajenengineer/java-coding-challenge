package com.mooveit.cars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@Entity(name = "model")
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "model_id")
	private Integer modelId;
	
	@NonNull
	private String name;
	
	private String line;
	private String fromDate;

	private String toDate;
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Engine engine;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wheel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Wheels wheels;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="sub_model_id")
	@JsonIgnore
	private SubModels subModel;

	@ManyToOne
	@JoinColumn(name="catalogue_id")
	@JsonIgnore
	private Catalogue catalogue;
	
	public Model(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Model{" + "id=" + modelId + ", name='" + name + '\'' + ", from='" + fromDate + '\'' + ", to='" + toDate + '\'' + ", type='" + type + '\'' + ", line='" + line + '\'' + ", engine=" + engine + ", wheel=" + wheels + ", subModels=" + subModel + '}';
	}
	
	
}
