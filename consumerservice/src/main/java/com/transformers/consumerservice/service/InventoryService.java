package com.transformers.consumerservice.service;

import com.transformers.consumerservice.models.Inventory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InventoryService {
    Map<String, Inventory> map = new ConcurrentHashMap<>();

    public Collection<Inventory> getInventory(){
        return map.values();
    }

    public void updateInventory(Inventory inventory){
        map.put(inventory.getId(), inventory);
    }
}
