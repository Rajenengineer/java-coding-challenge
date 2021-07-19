package com.mooveit.cars.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mooveit.cars.domain.Catalogue;
import com.mooveit.cars.domain.Model;
import com.mooveit.cars.execptionhandlers.BrandsException;
import com.mooveit.cars.service.spec.BrandDetailsSvc;
import com.mooveit.cars.util.Utility;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CarsController {

	@Autowired
	private BrandDetailsSvc brandSvc;

	@GetMapping(path = "/brand/{name}", produces = "application/json")
	public ResponseEntity<?> getAllCarSpecsByBrand(@PathVariable("name") String brandName) {

		log.info("returning all cars specs ");
		try {
			Optional<Catalogue> catalogue = brandSvc.getCatalogue(brandName);
			if (catalogue.isPresent()) {
				return ResponseEntity.ok().body(Utility.getCatalogueDto(catalogue.get()));
			}
		} catch (BrandsException e) {
			return ResponseEntity.badRequest().body("invalid request");
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/car/{id}", produces = "application/json")
	public ResponseEntity<?> getSingleCarSpecsById(@PathVariable("id") Integer modelId) {

		log.info("returning car specs ");
		Optional<Model> model = brandSvc.getModel(modelId);

		if (model.isPresent()) {
			return ResponseEntity.ok().body(Utility.getModelDto(model.get()));
		}
		return ResponseEntity.noContent().build();
	}

}
