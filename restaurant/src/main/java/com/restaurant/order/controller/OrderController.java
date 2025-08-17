package com.restaurant.order.controller;

import com.restaurant.advisor.exceptions.RestaurantNotFound;
import com.restaurant.menu.entity.Menu;
import com.restaurant.order.entity.Order;
import com.restaurant.order.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/placeorder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> placeOrder(
            @RequestParam("restaurantID") String restoId,
            @RequestBody List<Menu> orderItems,
            @RequestParam("tableNo") String tableNo) throws RestaurantNotFound {
        Order order = orderService.createOrder(restoId, orderItems, tableNo);
        return ResponseEntity.status(200).body(order);
    }

    @GetMapping
    public ResponseEntity<Order> getOrder(@RequestParam("orderId") String orderID) {
        return ResponseEntity.ok(orderService.getOrder(orderID));
    }

    @GetMapping(path = "/orders")
    public Map<String, Order> getAllOrders() {
        return orderService.getAllOrder();
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Order> updateOrder(
            @RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(order));
    }
}
