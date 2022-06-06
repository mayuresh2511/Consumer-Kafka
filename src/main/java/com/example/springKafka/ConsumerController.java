package com.example.springKafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

  private final MyConsumer myConsumer;

  public ConsumerController(MyConsumer myConsumer){
    this.myConsumer = myConsumer;
  }

  @GetMapping("/api/consumer")
  public List<EmployeeDTO> getMessages(){
    return myConsumer.getMessages();
  }
}
