package com.naveen.jsonworks;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaJsonSerializer implements Serializer{

	@Override
	public byte[] serialize(String topic, Object data) {
		
		byte[] retVal = null; 
		
		try {
			ObjectMapper om = new ObjectMapper(); 
			
			retVal = om.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		
		return retVal;
	}

	
	
}
