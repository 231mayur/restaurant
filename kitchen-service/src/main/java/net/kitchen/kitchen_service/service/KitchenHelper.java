package net.kitchen.kitchen_service.service;

import net.common.common_service.order.OrderDto;
import net.common.common_service.order.OrderStatus;

import java.util.HashMap;
import java.util.Map;

public class KitchenHelper {

    private KitchenHelper()
    {

    }

    private static final Map<String, OrderDto> ORDER_DTO_MAP = new HashMap<>();

    public static void putOrder(OrderDto orderDto)
    {
        orderDto.setStatus(OrderStatus.ORDER_PENDING);
        ORDER_DTO_MAP.put(orderDto.getId(), orderDto);
    }

    public static Map<String, OrderDto> getOrders() {
        return ORDER_DTO_MAP;
    }

    public static OrderDto getOrderById(String orderId) {
        return ORDER_DTO_MAP.get(orderId);
    }

    public static void updateOrderStatus(String orderId, OrderStatus orderStatus) {
        ORDER_DTO_MAP.get(orderId).setStatus(orderStatus);
    }
}
