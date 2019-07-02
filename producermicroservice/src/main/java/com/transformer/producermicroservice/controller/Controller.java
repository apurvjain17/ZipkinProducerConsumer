package com.transformer.producermicroservice.controller;

import com.transformer.producermicroservice.model.Inventory;
import com.transformer.producermicroservice.service.KafkaSource;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Logger logger = LogManager.getLogger(this.getClass().getName());

    @Autowired
    KafkaSource kafkaSource;

    @GetMapping("/hello")
    public String hello(){
        logger.info("Rest controller has been invoked");
        return "Hello world";
    }

    @PostMapping("/inventory")
    public ResponseEntity<Void> takeInventory(@RequestBody Inventory inventory){
        logger.info("Received request");
        kafkaSource.
                publishEvent(inventory);
        return ResponseEntity.ok().build();
    }

}
