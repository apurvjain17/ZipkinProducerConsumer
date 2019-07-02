package com.transformer.producermicroservice.service;

import com.transformer.producermicroservice.model.Inventory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KafkaSource {

    @Autowired
    private Source source;

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public void publishEvent(Inventory inventory){
        inventory.id = UUID.randomUUID().toString();
        logger.info("pushing object with id {}", inventory.id);
        source.output().send(MessageBuilder.withPayload(inventory).build());
    }

}
