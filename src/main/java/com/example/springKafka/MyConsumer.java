package com.example.springKafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyConsumer {

  private final List<EmployeeDTO> messages = new ArrayList<>();

  @KafkaListener(topics = "my_first", groupId = "kafka-sandbox")
  public void listen(EmployeeDTO message){
    synchronized (messages){
      System.out.println(message);
      messages.add(message);
    }
  }

  public List<EmployeeDTO> getMessages(){
    return messages;
  }
}
