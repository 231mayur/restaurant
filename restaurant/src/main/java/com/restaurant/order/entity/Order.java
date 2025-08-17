package com.restaurant.order.entity;

import com.restaurant.menu.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private String restoId;
    private String tableNo;
    private List<Menu> orderedItems;
    private String status;
    private double totalPrice;
    private String paymentStaus;
}
