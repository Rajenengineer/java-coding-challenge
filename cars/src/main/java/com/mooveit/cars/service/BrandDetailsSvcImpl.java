package com.mooveit.cars.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mooveit.cars.domain.Catalogue;
import com.mooveit.cars.domain.Model;
import com.mooveit.cars.enums.Brands;
import com.mooveit.cars.enums.ExceptionMessages;
import com.mooveit.cars.execptionhandlers.BrandsException;
import com.mooveit.cars.repositories.CatalogueRepository;
import com.mooveit.cars.repositories.ModelRepository;
import com.mooveit.cars.service.spec.BrandDetailsSvc;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BrandDetailsSvcImpl implements BrandDetailsSvc {

	@Autowired
	private CatalogueRepository catalogueRepo;
	
	@Autowired
	private ModelRepository modelRepository;

	public Optional<Catalogue> getCatalogue(String brandName) throws BrandsException {
		
		// hardcoding the exception logic, for FORD being as the current brand of our scope here.
		
		if(!brandName.equalsIgnoreCase(Brands.FORD.getBrandName())) {
			log.error(ExceptionMessages.INVALID_BRAND.getExceptionMessage());
			throw new BrandsException(ExceptionMessages.INVALID_BRAND.getExceptionMessage());
		}
		return catalogueRepo.getCatalogueByBrandName(brandName);
	}
	
	public Optional<Model> getModel(Integer id){
		return modelRepository.getModelByModelId(id);
	}
	
}
