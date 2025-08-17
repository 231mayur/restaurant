package net.kitchen.kitchen_service.service;

import net.common.common_service.order.OrderDto;
import net.common.common_service.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class KitchenService {

    @Autowired
   static RestTemplate restTemplate;

    @Bean
    public RestTemplate getTemplate()
    {
        return new RestTemplate();
    }

    public static void updateOrderStatus(String orderId, OrderStatus orderStatus) {
        KitchenHelper.updateOrderStatus(orderId, orderStatus);
    }

    public Map<String, OrderDto> getOrders() {
        return KitchenHelper.getOrders();
    }

    public OrderDto getOrderById(String orderId) {

        return KitchenHelper.getOrderById(orderId);
    }
}
