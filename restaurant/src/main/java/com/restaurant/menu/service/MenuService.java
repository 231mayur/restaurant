package com.restaurant.menu.service;

import com.restaurant.menu.MenuHelper;
import com.restaurant.menu.entity.Menu;
import com.restaurant.advisor.exceptions.RestaurantNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    MenuHelper menuHelper;

    @Autowired
    public MenuService(MenuHelper menuHelper) {
        this.menuHelper = menuHelper;
    }


    /**
     * Retrieves a list of all menu items.
     *
     * @return Map of Menu objects representing the menu items.
     */
    public Map<String, List<Menu>> getAllRestaurant() {
        return menuHelper.getAllRestaurant();
    }


    /**
     * Retrieves the menu for a specific restaurant.
     *
     * @param restaurantId The ID of the restaurant for which to retrieve the menu.
     * @return List of Menu objects representing the menu for the specified restaurant.
     * @throws RestaurantNotFound if the restaurant with the given ID does not exist.
     */
    public List<Menu> getMenuByRestaurant(String restaurantId) throws RestaurantNotFound {
        return menuHelper.getMenuByRestaurant(restaurantId);
    }

    /**
     * Adds a new menu item to a specific restaurant.
     *
     * @param menu The Menu object to be added.
     * @param restaurantId The ID of the restaurant to which the menu item belongs.
     * @throws RestaurantNotFound if the restaurant with the given ID does not exist.
     */
    public void addMenu(Menu menu, String restaurantId) throws RestaurantNotFound {
        menuHelper.addMenu(restaurantId, menu);
    }

    public boolean removeMenu(String restaurantId, String menuId ) throws RestaurantNotFound {
       return menuHelper.removeMenuById(restaurantId, menuId);
    }

}
