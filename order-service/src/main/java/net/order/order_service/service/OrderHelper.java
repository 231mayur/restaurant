package net.order.order_service.service;

import lombok.Getter;
import net.common.common_service.menu.MenuDto;
import net.common.common_service.order.OrderStatus;
import net.order.order_service.entity.OrderEntity;

import java.util.*;

public class OrderHelper {

    @Getter
    private static  final Map<String, OrderEntity> orders = new HashMap<>();

    static
    {
        // replace with DB
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTable("20");
        orderEntity.setStatus(OrderStatus.ORDER_PLACED);
        MenuDto mpizza = new MenuDto(UUID.randomUUID().toString(),"Margherita Pizza", "Classic cheese pizza", 299.99, "Vegetarian", 10, true);
        MenuDto paratha = new MenuDto(UUID.randomUUID().toString(),"paratha", "Paratha", 100, "Vegetarian", 10, false);
        MenuDto thali = new MenuDto(UUID.randomUUID().toString(),"Thali", "Thali with pure veg", 150, "Vegetarian", 5, true);
        List<MenuDto> menus = Arrays.asList(mpizza, paratha, thali);
        orderEntity.setMenus(menus);
        orders.put(UUID.randomUUID().toString(), orderEntity);
    }

    public static void createOrder(String id, OrderEntity orderEntity) {
        orders.put(id, orderEntity);
    }

    public static OrderEntity updateOrder(String  orderId, OrderEntity orderEntity)
    {
        // add logic to check if order is present
        orders.put(orderId, orderEntity);
        return orderEntity;
    }

    public static OrderEntity getOrderById(String orderId) {
        return orders.get(orderId);
    }
}
