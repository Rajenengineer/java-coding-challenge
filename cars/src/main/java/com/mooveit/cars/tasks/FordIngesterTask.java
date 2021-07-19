package com.mooveit.cars.tasks;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.mooveit.cars.domain.*;
import com.mooveit.cars.dto.CatalogueDto;
import com.mooveit.cars.repositories.CatalogueRepository;
import com.mooveit.cars.repositories.EngineRepository;
import com.mooveit.cars.repositories.ModelRepository;
import com.mooveit.cars.repositories.SubModelsRepository;
import com.mooveit.cars.repositories.WheelsRepository;
import com.mooveit.cars.util.Utility;
import com.mooveit.cars.util.XstreamParserUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FordIngesterTask {

	@Autowired
	private CatalogueRepository catalogueRepository;
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private EngineRepository engineRepository;
	@Autowired
	private WheelsRepository wheelsRepository;
	@Autowired
	private SubModelsRepository subModelsRepository;

	@Scheduled(cron = "${cars.ford.ingester.runCron}")
	public void ingestFile() throws IOException {
		Resource resource = new ClassPathResource("ford-example.xml");
		String content = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()), StandardCharsets.UTF_8);
		CatalogueDto catalogueDto = XstreamParserUtil.convertXmlToPojo(content);

		Catalogue catalogue = Utility.getCatalogueFromDto(catalogueDto);

		log.debug(" Catalogue contents", catalogue.toString());

		catalogue.getModels().forEach(model -> {

			if (!modelRepository.getModelByName(model.getName()).isPresent()) {

				Catalogue cat = catalogueRepository.save(catalogue);
				engineRepository.save(model.getEngine());
				wheelsRepository.save(model.getWheels());
				SubModels subModels = model.getSubModel();

				subModels.getModels().forEach(nestedModel -> {
					
					
					
					Engine engine = engineRepository.save(nestedModel.getEngine());
					Wheels wheels = wheelsRepository.save(nestedModel.getWheels());
					nestedModel.setEngine(engine);
					nestedModel.setWheels(wheels);
					nestedModel.setCatalogue(cat);
					nestedModel = modelRepository.save(nestedModel);
				});
				subModelsRepository.save(subModels);
				model.setSubModel(subModels);
				model.setCatalogue(cat);
				model = modelRepository.save(model);
			} else {
				log.debug("no new model, this already exists in list ");
			}
		});

	}
}
