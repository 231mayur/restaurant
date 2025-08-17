package com.restaurant.menu.controller;

import com.restaurant.menu.entity.Menu;
import com.restaurant.advisor.exceptions.RestaurantNotFound;
import com.restaurant.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurant")
public class MenuController {

    private MenuService menuService;

    @Autowired
    MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * Endpoint to retrieve all restaurant menus.
     *
     * @return A map where the key is the restaurant ID and the value is a list of Menu objects.
     */
    @GetMapping
    public Map<String, List<Menu>> getAllRestaurant() {
        return menuService.getAllRestaurant();
    }

    /**
     * Endpoint to add a new menu item for a specific restaurant.
     *
     * @param menu         The Menu object to be added.
     * @param restaurantId The ID of the restaurant to which the menu item belongs.
     */
    @PostMapping(path = "/add/{restaurantId}")
    public ResponseEntity<String> addMenu(@RequestBody Menu menu, @PathVariable String restaurantId) throws RestaurantNotFound {
        menuService.addMenu(menu, restaurantId);
        return ResponseEntity.ok("Menu id " + menu.getId() + " added!");
    }

    /**
     * Endpoint to retrieve the menu for a specific restaurant.
     *
     * @param restaurantId The ID of the restaurant for which to retrieve the menu.
     * @return A list of Menu objects representing the menu for the specified restaurant.
     */
    @GetMapping(path = "/{restaurantId}/menu")
    public List<Menu> getMenuByRestaurant(@PathVariable String restaurantId) throws RestaurantNotFound {
        return menuService.getMenuByRestaurant(restaurantId);
    }

    @DeleteMapping(path = "/remove")
    public ResponseEntity<String> removeMenu(@RequestParam("restaurantId") String restoId,
                                     @RequestParam("menuid") String menuId) throws RestaurantNotFound
    {
        if (menuService.removeMenu(restoId, menuId))
        {
            return ResponseEntity.ok("Menu id " + menuId + " deleted!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
