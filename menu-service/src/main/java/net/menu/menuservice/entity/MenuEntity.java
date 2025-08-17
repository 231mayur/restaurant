package net.menu.menuservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity {

    private String name;
    private String description;
    private double price;
    private String category;
    private double discount;
    private boolean isAvailable;
}
