package com.mooveit.cars.service.spec;

import java.util.Optional;

import com.mooveit.cars.domain.Catalogue;
import com.mooveit.cars.domain.Model;

public interface BrandDetailsSvc {

	public Optional<Catalogue> getCatalogue(String brandName);
	public Optional<Model> getModel(Integer id);
}
