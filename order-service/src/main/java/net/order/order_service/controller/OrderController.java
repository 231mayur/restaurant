package net.order.order_service.controller;

import net.order.order_service.entity.OrderEntity;
import net.order.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "rest/v1")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/orders",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, OrderEntity> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping(path = "/createOrder", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder(@RequestBody OrderEntity orderEntity) {
        orderService.createOrder(orderEntity);
        return ResponseEntity.ok("Order has been placed");
    }

    @PutMapping(path = "/update")
    public OrderEntity updateOrder(@RequestParam(name = "orderid") String orderId,
                                   @RequestBody OrderEntity orderEntity) {

        return orderService.updateOrder(orderId, orderEntity);
    }

    @GetMapping(path = "/order")
    public OrderEntity getOrderById(@RequestParam("orderid") String orderId)
    {
        return orderService.getOrderByID(orderId);
    }

}
