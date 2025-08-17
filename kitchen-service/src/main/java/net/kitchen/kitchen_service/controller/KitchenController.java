package net.kitchen.kitchen_service.controller;

import net.common.common_service.order.OrderDto;
import net.common.common_service.order.OrderStatus;
import net.kitchen.kitchen_service.service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/kitchen/v1")
public class KitchenController {

    private KitchenService kitchenService;

    @Autowired
    KitchenController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping(path = "/orders",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, OrderDto> getOrders() {
        return kitchenService.getOrders();
    }

    @GetMapping(path = "/order",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto getOrderById(@RequestParam("orderid") String orderId) {
        return kitchenService.getOrderById(orderId);
    }

    @PutMapping(path = "update",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateOrderStatus(@RequestParam("orderId") String orderId,
                                              @RequestParam("status") OrderStatus orderStatus) {
        KitchenService.updateOrderStatus(orderId, orderStatus);
        return ResponseEntity.ok("Order has been created "+ orderId);
    }
}
