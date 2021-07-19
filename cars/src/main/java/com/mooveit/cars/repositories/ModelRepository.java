package com.mooveit.cars.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mooveit.cars.domain.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

	Optional<Model> getModelByName(String name);
	Optional<Model> getModelByModelId(Integer modelId);
}
