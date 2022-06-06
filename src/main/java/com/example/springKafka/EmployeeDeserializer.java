package com.example.springKafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class EmployeeDeserializer implements Deserializer {

  @Override
  public void configure(Map configs, boolean isKey) {

  }

  @Override
  public EmployeeDTO deserialize(String s, byte[] bytes) {
    ObjectMapper objectMapper = new ObjectMapper();
    EmployeeDTO employee = null;

    try {
      employee = objectMapper.readValue(bytes, EmployeeDTO.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return employee;
  }


  @Override
  public void close() {

  }
}
