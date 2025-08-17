package net.common.common_service.order;

import lombok.*;
import net.common.common_service.menu.MenuDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {
    private String id;
    private List<MenuDto> menus;
    private String table;
    private OrderStatus status;
}
