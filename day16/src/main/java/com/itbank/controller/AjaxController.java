package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.itbank.component.ParkingInfoComponent;
import com.itbank.util.ResultType;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	@Autowired private ParkingInfoComponent parkingInfoComponent;
	
	@GetMapping("/parking/{resultType}")
	public String parking(@PathVariable("resultType") String resultType) throws IOException  {
		resultType = resultType.toUpperCase();		// json을 JSON으로 변경
		String data = parkingInfoComponent.getString(ResultType.valueOf(resultType));
		return data;
	}
	
	private XmlMapper xmlMapper = new XmlMapper();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	// XML형식으로 요청하여  JSON으로 변환 후 반환하는 함수
	@GetMapping("/parking")
	public String parking() throws IOException {
		String xmlData = parkingInfoComponent.getString(ResultType.XML);
		System.out.println(xmlData);
		
		JsonNode jsonNode = xmlMapper.readTree(xmlData.getBytes());
		String jsonData = objectMapper.writeValueAsString(jsonNode);		
		
		return jsonData;
		// xmltojson 20220920
		// jackson-dataformat-xml			(xml -> java(DTO) -> json)
		// org.json
		// org.gson
	
	}
}
