package com.mooveit.cars.dto;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import lombok.Data;

@Data
@XStreamAlias("SUBMODELS")
public class SubModelsDto {
	@XStreamOmitField
	private Integer id;
	@XStreamImplicit(itemFieldName = "MODEL")
	private List<ModelDto> modelsDtos = new ArrayList<>();

	public SubModelsDto() {
	}

	public SubModelsDto(List<ModelDto> modelsDtos) {
		this.modelsDtos = modelsDtos;
	}

	@Override
	public String toString() {
		return "SubModelsDto{" + "id=" + id + ", modelsDtos=" + modelsDtos + '}';
	}
}
