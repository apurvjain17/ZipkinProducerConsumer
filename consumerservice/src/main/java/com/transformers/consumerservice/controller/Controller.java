package com.transformers.consumerservice.controller;

import com.transformers.consumerservice.models.Inventory;
import com.transformers.consumerservice.service.InventoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class Controller {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/inventory")
    public Collection<Inventory> getInventory(){
        logger.info("Got Request for get Inventory");
        return inventoryService.getInventory();
    }

}
