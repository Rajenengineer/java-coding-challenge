package com.mooveit.cars.util;

import com.mooveit.cars.dto.CatalogueDto;
import com.mooveit.cars.dto.EngineDto;
import com.mooveit.cars.dto.ModelDto;
import com.mooveit.cars.dto.SubModelsDto;
import com.mooveit.cars.dto.WheelsDto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class XstreamParserUtil {
		
	private static XStream getXStream() {
		final XStream xstream = new XStream(new StaxDriver());
		xstream.autodetectAnnotations(true);
		xstream.processAnnotations(CatalogueDto.class);
		xstream.processAnnotations(ModelDto.class);
		xstream.processAnnotations(EngineDto.class);
		xstream.processAnnotations(WheelsDto.class);
		xstream.processAnnotations(SubModelsDto.class);
		return xstream;
	}

	public static CatalogueDto convertXmlToPojo(String xmlInput) {
		final XStream xstream = getXStream();
		xstream.setMode(XStream.ID_REFERENCES);
		return (CatalogueDto) xstream.fromXML(xmlInput);
	}	
}
