package com.restaurant.menu;

import com.restaurant.menu.entity.Menu;
import com.restaurant.advisor.exceptions.RestaurantNotFound;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class MenuHelper {

    private static HashMap<String, List<Menu>> allRestaurants = new HashMap<>();

    static {

        List<Menu> radisonMenu = new ArrayList<>();
        radisonMenu.add(new Menu("1", "Margherita Pizza", "Classic cheese pizza", 299.99, "Vegetarian", 10, true));

        List<Menu> lemonTreeMenu = new ArrayList<>();
        lemonTreeMenu.add(new Menu("2", "Spaghetti Carbonara", "Creamy pasta with pancetta", 399.99, "Non-Vegetarian", 15, true));
        allRestaurants.put("1", radisonMenu);
        allRestaurants.put("2", lemonTreeMenu);
    }

    public Map<String, List<Menu>> getAllRestaurant() {
        return allRestaurants;
    }

    public List<Menu> getMenuByRestaurant(String restaurantId) throws RestaurantNotFound {

        checkIfRestaurantExists(restaurantId);
        return allRestaurants.get(restaurantId);
    }

    public void addMenu(String restaurantId, Menu menu)  throws RestaurantNotFound
    {
        checkIfRestaurantExists(restaurantId);
        allRestaurants.get(restaurantId).add(menu);
    }

    public boolean removeMenuById(String restaurantId, String menuid) throws RestaurantNotFound
    {
        checkIfRestaurantExists(restaurantId);
        List<Menu> menus = allRestaurants.get(restaurantId);
        menus.removeIf(menu -> menu.getId().equals(menuid));
        return true;
    }
    
    private void checkIfRestaurantExists(String restaurantId) throws RestaurantNotFound {
        if (!allRestaurants.containsKey(restaurantId)) {
            throw new RestaurantNotFound("RESTO-SERVICE", "Restaurant not found: " + restaurantId);
        }
    }

}
