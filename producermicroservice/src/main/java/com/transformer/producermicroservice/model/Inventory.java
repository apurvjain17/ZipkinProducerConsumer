package com.transformer.producermicroservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Inventory {
    public String id;
    public String productName;
    public Integer quantity;
    public String sellerId;
    public String orgId;
}
