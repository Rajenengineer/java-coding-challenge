package com.mooveit.cars.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Catalogue;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
	
	Optional<Catalogue> getCatalogueByBrandName(String brandName);
	
}
