package net.order.order_service.service;

import net.common.common_service.order.OrderDto;
import net.order.order_service.entity.OrderEntity;
import net.order.order_service.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    private KafkaProducer kafkaProducer;

    @Autowired
    OrderService(KafkaProducer kafkaProducer)
    {
        this.kafkaProducer = kafkaProducer;
    }

    public Map<String, OrderEntity> getOrders() {
        return OrderHelper.getOrders();
    }

    public void createOrder(OrderEntity orderEntity) {
        String id = UUID.randomUUID().toString();
        OrderHelper.createOrder(id, orderEntity);
        OrderDto orderDto = new OrderDto(id, orderEntity.getMenus(), orderEntity.getTable(), orderEntity.getStatus());

        kafkaProducer.sendMessage(orderDto);
    }

    public OrderEntity updateOrder(String orderId, OrderEntity orderEntity) {
        String id = UUID.randomUUID().toString();
        OrderHelper.updateOrder(id, orderEntity);
        OrderDto orderDto = new OrderDto(orderId, orderEntity.getMenus(), orderEntity.getTable(), orderEntity.getStatus());
        kafkaProducer.sendMessage(orderDto);
        return orderEntity;
    }

    public OrderEntity getOrderByID(String orderId) {
        return OrderHelper.getOrderById(orderId);
    }

}
