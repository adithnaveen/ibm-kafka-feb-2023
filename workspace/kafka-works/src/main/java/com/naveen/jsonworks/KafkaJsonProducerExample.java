package com.naveen.jsonworks;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaJsonProducerExample {
	private static final Logger log = LoggerFactory.getLogger(KafkaJsonProducerExample.class.getName()); 
	
	
	public static void main(String[] args) {
		final String PORT = "9092";
		final String HOST = "localhost";

		Properties prop = new Properties();

		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST + ":" + PORT);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


		EmployeeDAO dao = new EmployeeDAO(); 
		
		Employee emp = dao.getEmployee(103, "Ravi");
		
		ProducerRecord<String, Employee> producerRecord = 
					new ProducerRecord<String, Employee>
					("d2-first-topic", emp);
		
		KafkaProducer<String, Employee> kafkaProducer = 
			new KafkaProducer<>(prop, new StringSerializer(), new KafkaJsonSerializer());
		
		
		

		
		kafkaProducer.send(producerRecord, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if(exception==null) {
					log.info("------------------------------------"); 
					log.info("Message Send Successfully"); 
					log.info("------------------------------------");
					
					log.info("Topic : " + metadata.topic() +
							 "Partition : " + metadata.partition() +
							 "Offset : " + metadata.offset() +
							 "Time Stamp : " + new Date(metadata.timestamp()));
				}else {
					log.error("Sorry Message Not Sent To Kafka {}", exception);
				}
			}
		});
		
		kafkaProducer.flush();
		kafkaProducer.close();
		
		
		
	}
}












