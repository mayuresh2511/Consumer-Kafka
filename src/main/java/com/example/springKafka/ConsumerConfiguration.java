package com.example.springKafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfiguration {

  private static final String KAFKA_BROKER = "127.0.0.1:9092";
  private static final String KAFKA_GROUP = "kafka-sandbox";

  @Bean
  public Map<String, Object> configurationConsumer(){
    Map<String, Object> configuration = new HashMap<>();

    configuration.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
    configuration.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    configuration.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EmployeeDeserializer.class);
    configuration.put(ConsumerConfig.GROUP_ID_CONFIG, KAFKA_GROUP);

    return configuration;
  }

  @Bean
  public ConsumerFactory<String, EmployeeDTO> consumerFactory(){
    return new DefaultKafkaConsumerFactory<>(configurationConsumer());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO> kafkaListenerContainerFactory(){
    ConcurrentKafkaListenerContainerFactory<String, EmployeeDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

}
