package com.itbank.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.itbank.component.ApiComponent;
import com.itbank.component.CampingComponent;
import com.itbank.util.ResultType;

@RestController
@RequestMapping("/ajax")
public class AjaxController {
	
	@Autowired private ApiComponent apiComponent;
	@Autowired private CampingComponent campingComponent;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	private XmlMapper xmlMapper = new XmlMapper();
	
	@GetMapping("/camping")
	public String camping() throws IOException {
		String xmlData = apiComponent.getString(ResultType.XML);
		System.out.println(xmlData);
		
		JsonNode jsonNode = xmlMapper.readTree(xmlData.getBytes());
		String jsonData = objectMapper.writeValueAsString(jsonNode);
		System.out.println(jsonData);
		
		return jsonData;
	}
	
	@GetMapping("/camping_around")
	public String view_around(@RequestParam HashMap<String, String> param) throws IOException {
		String xmlData = campingComponent.getCampingList(ResultType.XML, param);
		System.out.println(xmlData);
		
		JsonNode jsonNode = xmlMapper.readTree(xmlData.getBytes());
		String campingList = objectMapper.writeValueAsString(jsonNode);
		System.out.println(campingList);
		
		return campingList;
	}

}
