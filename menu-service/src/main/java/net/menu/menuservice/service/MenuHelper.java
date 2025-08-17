package net.menu.menuservice.service;

import net.menu.menuservice.advisor.exceptions.MenuNotFound;
import net.menu.menuservice.entity.MenuEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MenuHelper {

    private static final HashMap<String, MenuEntity> allMenus = new HashMap<>();

    static {
        allMenus.put(UUID.randomUUID().toString(), new MenuEntity("Margherita Pizza", "Classic cheese pizza", 299.99, "Vegetarian", 10, true));
        allMenus.put(UUID.randomUUID().toString(), new MenuEntity("Spaghetti Carbonara", "Creamy pasta with pancetta", 399.99, "Non-Vegetarian", 15, true));
    }

    public Map<String, MenuEntity> getAllMenu() {
        return allMenus;
    }

    public MenuEntity getMenuID(String menuID) throws MenuNotFound {

        checkIfMenuExists(menuID);
        return allMenus.get(menuID);
    }

    public void addMenu(MenuEntity menu) {
        allMenus.put(UUID.randomUUID().toString(), menu);
    }

    public boolean removeMenuById(String menuId) throws MenuNotFound {
        checkIfMenuExists(menuId);
        allMenus.remove(menuId);
        return true;
    }

    private void checkIfMenuExists(String menuId) throws MenuNotFound {
        if (!allMenus.containsKey(menuId)) {
            throw new MenuNotFound("Menu not found id:" + menuId);
        }
    }

}
