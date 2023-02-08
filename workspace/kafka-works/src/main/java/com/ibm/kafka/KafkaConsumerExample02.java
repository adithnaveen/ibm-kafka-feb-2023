package com.ibm.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerExample02 {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerExample02.class.getName());
	
	public static void main(String args[]) {
		final String PORT = "9092"; 
		final String HOST = "localhost"; 
		
		Properties prop = new Properties();
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST +":" + PORT); 
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()); 
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		prop.put(ConsumerConfig.GROUP_ID_CONFIG, "my-java-group");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Arrays.asList("d2-first-topic"));
		
	}
}
