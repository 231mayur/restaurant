package com.restaurant.order.orderService;

import com.restaurant.menu.entity.Menu;
import com.restaurant.order.entity.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderUtilities {
    private static HashMap<String, Order> orderItemsMap = new HashMap<>();

    private OrderUtilities()
    {

    }

    public static Order getOrder(String orderId) {
        return orderItemsMap.get(orderId);
    }

    public static Order createOrder(String restoId, List<Menu> orderItems, String tableNo) {
        Order order = new Order();
        String orderId = UUID.randomUUID().toString();
        order.setOrderId(orderId);
        order.setPaymentStaus("Not Done");
        order.setRestoId(restoId);
        order.setStatus("Placed");
        order.setTableNo(tableNo);
        order.setTotalPrice(finalPrice(orderItems));
        order.setOrderedItems(orderItems);
        orderItemsMap.put(orderId, order);
        return order;
    }

    private static double finalPrice(List<Menu> menus) {
        return menus.stream()
                .mapToDouble(menu -> menu.getPrice() - (menu.getPrice() * menu.getDiscount() / 100))
                .sum();
    }

    public static Map<String, Order> getAllOrders() {
        return orderItemsMap;
    }

    public static Order updateOrder(Order order) {
        order.setTotalPrice(finalPrice(order.getOrderedItems()));
        orderItemsMap.put(order.getOrderId(), order);
        return order;
    }
}
