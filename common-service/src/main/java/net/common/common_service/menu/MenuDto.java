package net.common.common_service.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private double discount;
    private boolean isAvailable;
}
