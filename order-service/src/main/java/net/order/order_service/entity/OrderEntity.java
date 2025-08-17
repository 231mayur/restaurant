package net.order.order_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.common.common_service.menu.MenuDto;
import net.common.common_service.order.OrderStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity
{
    private List<MenuDto> menus;
    private String table;
    private OrderStatus status;
}
