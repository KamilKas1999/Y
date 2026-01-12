package com.kasprzak.kamil.demoapp.item;

import lombok.Data;

@Data
public class CreateItemRequest {

    private String name;
    private String description;
}
