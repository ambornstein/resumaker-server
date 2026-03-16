package com.backend.service.resume.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JSONConverter implements AttributeConverter<Map<String, Object>, String> {
	 private static final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Object> mapObject) {
		String JSONObject = null;
		try {
			JSONObject = objectMapper.writeValueAsString(mapObject);
		} catch (Exception e) {
			//
		}
		
		return JSONObject;
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String string) {
		
		Map<String, Object> mapObject = null;
		try {
			mapObject = objectMapper.readValue(string, new TypeReference<HashMap<String, Object>>() {});
		} catch (Exception e) {
			// TODO: handle exception
		}

		return mapObject;
 	}
}
