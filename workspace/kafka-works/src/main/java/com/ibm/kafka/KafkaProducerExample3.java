package com.ibm.kafka;

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

public class KafkaProducerExample3 {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducerExample3.class.getName());

	public static void main(String args[]) {
		final String PORT = "9092";
		final String HOST = "localhost";

		Properties prop = new Properties();

//		prop.put("bootstrap.servers", HOST +":" + PORT);
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, HOST + ":" + PORT);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

		for (int i = 0; i < 100; i++) {

			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("d2-first-topic",
					"Hello From Java " + i);

			
//			new ProducerRecord<>("d2-first-topic", 0, "101", "Name")
			
			producer.send(producerRecord, new Callback() {

				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if (exception == null) {
						log.info("------------------------------------");
						log.info("Message Send Successfully");
						log.info("------------------------------------");

						log.info("Topic : " + metadata.topic() + "Partition : " + metadata.partition() + "Offset : "
								+ metadata.offset() + "Time Stamp : " + new Date(metadata.timestamp()));
					} else {
						log.error("Sorry Message Not Sent To Kafka {}", exception);
					}
				}
				
			
			});
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		producer.flush();
		producer.close();

	}

}
