package com.mooveit.cars.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.mooveit.cars.domain.Catalogue;
import com.mooveit.cars.domain.Engine;
import com.mooveit.cars.domain.Model;
import com.mooveit.cars.domain.SubModels;
import com.mooveit.cars.domain.Wheels;
import com.mooveit.cars.dto.*;

public class Utility {
	
	public static CatalogueDto getCatalogueDto(Catalogue catalogue) {
		List<ModelDto> modelDtos = null;
		if(CollectionUtils.isNotEmpty(catalogue.getModels())) {
			modelDtos = catalogue.getModels().stream().map(Utility::getModelDto).collect(Collectors.toList());
		}
		CatalogueDto dto = new CatalogueDto(Objects.nonNull(modelDtos) ? modelDtos : new ArrayList<>());
		dto.setId(catalogue.getCatalogueId());
		return dto;
	}

	public static Catalogue getCatalogueFromDto(CatalogueDto dto) {
		List<Model> models = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(dto.getModelsDtos())) {
			models = dto.getModelsDtos().stream().map(Utility::getModelFromDto).collect(Collectors.toList());
		}
		Catalogue catalogue = new Catalogue(models);
		catalogue.setCatalogueId(dto.getId());
		return catalogue;
	}

	public static ModelDto getModelDto(Model model) {
		ModelDto dto = new ModelDto();
		dto.setId(model.getModelId());
		dto.setFrom(model.getFromDate());
		dto.setTo(model.getToDate());
		dto.setName(model.getName());
		dto.setLine(model.getLine());

		dto.setType(model.getType());
		if(Objects.nonNull(model.getEngine())) {
			dto.setEngineDto(Utility.getEngineDto(model.getEngine()));
		}
		if(Objects.nonNull(model.getWheels())) {
			dto.setWheelsDto(Utility.getWheelsDto(model.getWheels()));
		}
		if(Objects.nonNull(model.getSubModel())) {
			dto.setSubModelsDto(Utility.getSubModelsDto(model.getSubModel()));
		}
		return dto;
	}

	public static Model getModelFromDto(ModelDto dto) {
		Model model = new Model();
		model.setModelId(dto.getId());
		model.setFromDate(dto.getFrom());
		model.setToDate(dto.getTo());
		model.setName(dto.getName());
		model.setType(dto.getType());
		model.setLine(dto.getLine());
		if(Objects.nonNull(dto.getEngineDto())) {
			model.setEngine(Utility.getEngineFromDto(dto.getEngineDto()));
		}
		if(Objects.nonNull(dto.getWheelsDto())) {
			model.setWheels(Utility.getWheelsFromDto(dto.getWheelsDto()));
		}
		if(Objects.nonNull(dto.getSubModelsDto())) {
			model.setSubModel(Utility.fromSubModelsDto(dto.getSubModelsDto()));
		}
		return model;
	}

	public static EngineDto getEngineDto(Engine engine) {
		EngineDto dto = new EngineDto(engine.getPower(), engine.getType());
		dto.setId(engine.getEngineId());
		return dto;
	}

	public static Engine getEngineFromDto(EngineDto dto) {
		Engine engine = new Engine(dto.getPower(), dto.getType());
		engine.setEngineId(dto.getId());
		return engine;
	}

	public static WheelsDto getWheelsDto(Wheels wheels) {
		WheelsDto dto = new WheelsDto(wheels.getSize(), wheels.getType());
		dto.setId(wheels.getWheelId());
		return dto;
	}

	public static Wheels getWheelsFromDto(WheelsDto dto) {
		Wheels wheels = new Wheels(dto.getSize(), dto.getType());
		wheels.setWheelId(dto.getId());
		return wheels;
	}

	public static ModelDto getNestedSubModelDto(Model  model) {
		ModelDto dto = new ModelDto();
		dto.setId(model.getModelId());
		dto.setFrom(model.getFromDate());
		dto.setTo(model.getToDate());
		dto.setName(model.getName());
		dto.setLine(model.getLine());
		dto.setType(model.getType());
		if(Objects.nonNull(model.getEngine())) {
			dto.setEngineDto(Utility.getEngineDto(model.getEngine()));
		}
		if(Objects.nonNull(model.getWheels())) {
			dto.setWheelsDto(Utility.getWheelsDto(model.getWheels()));
		}
		return dto;
	}
	
	public static SubModelsDto getSubModelsDto(SubModels subModels) {
		List<ModelDto> modelDtos = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(subModels.getModels())) {
			modelDtos = subModels.getModels().stream().map(Utility::getNestedSubModelDto).collect(Collectors.toList());
		}
		
		SubModelsDto dto = new SubModelsDto(modelDtos);
		dto.setId(subModels.getSubModelId());
		return dto;
	}


	public static SubModels fromSubModelsDto(SubModelsDto dto) {
		List<Model> models = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(dto.getModelsDtos())) {
			models = dto.getModelsDtos().stream().map(Utility::getModelFromDto).collect(Collectors.toList());
		}
		SubModels subModels = new SubModels(models);
		subModels.setSubModelId(dto.getId());
		return subModels;
	}

}
