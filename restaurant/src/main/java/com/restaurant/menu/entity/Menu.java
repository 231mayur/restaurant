package com.restaurant.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Menu
{
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private double discount;
    private boolean isAvailable;
}
