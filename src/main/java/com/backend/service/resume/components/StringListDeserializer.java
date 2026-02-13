package com.backend.service.resume.components;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StringListDeserializer extends JsonDeserializer<List<String>>{

	@Override
	public List<String> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		String value = jp.getText();
		if (value == null || value.isEmpty()) {
            return Collections.emptyList();
        }
		
		return Arrays.asList(value.split(";")).stream().map(String::trim).toList();
	}

}
