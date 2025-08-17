package com.restaurant.order.orderService;

import com.restaurant.advisor.exceptions.RestaurantNotFound;
import com.restaurant.menu.entity.Menu;
import com.restaurant.menu.service.MenuService;
import com.restaurant.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private MenuService menuService;

    @Autowired
    OrderService(MenuService menuService)
    {
        this.menuService = menuService;
    }

    public Order createOrder(String restoId, List<Menu> orderItems, String tableNo) throws RestaurantNotFound {
        menuService.getMenuByRestaurant(restoId);
        return OrderUtilities.createOrder(restoId, orderItems, tableNo);
    }

    public Order getOrder(String orderID)
    {
        return OrderUtilities.getOrder(orderID);
    }

    public Map<String, Order> getAllOrder() {
        return OrderUtilities.getAllOrders();
    }

    public Order updateOrder(Order order)
    {
        return OrderUtilities.updateOrder(order);
    }
}
