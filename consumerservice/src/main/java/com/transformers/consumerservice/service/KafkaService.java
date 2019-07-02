package com.transformers.consumerservice.service;

import com.transformers.consumerservice.models.Inventory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@EnableBinding(Sink.class)
public class KafkaService {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    @Autowired
    InventoryService service;

    @StreamListener(Sink.INPUT)
    public void inventorySink(Inventory inventory){
        logger.info("received inventory {}", inventory.id);
        service.updateInventory(inventory);
    }

}
