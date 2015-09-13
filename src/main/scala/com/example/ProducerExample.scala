package com.example

import com.typesafe.config.ConfigFactory
import kafka.producer.KeyedMessage
import java.util.Properties
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

object ProducerExample {

  def main(args:Array[String]):Unit = {
     val conf = ConfigFactory.load();
	 val brokerList=conf.getString("producer.metadata.broker.list")
	 val props = new Properties()
	 
	 props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
	 props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	 props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
	 
	 val producer=new KafkaProducer[String,String](props)			
	 
	 val message= new ProducerRecord[String,String]("topic1","key1","Hello Akka")
	 producer.send(message)
     producer.close()  
  }
  
  

}