package net.menu.menuservice.service;


import net.common.common_service.menu.MenuDto;
import net.menu.menuservice.advisor.exceptions.MenuNotFound;
import net.menu.menuservice.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MenuService {

    MenuHelper menuHelper;

    @Autowired
    public MenuService(MenuHelper menuHelper) {
        this.menuHelper = menuHelper;
    }

    public Map<String, MenuEntity> getAllMenu() {
        return menuHelper.getAllMenu();
    }

    public MenuDto getByMenuID(String menuID) throws MenuNotFound {
        MenuEntity menuEntity = menuHelper.getMenuID(menuID);
        MenuDto menuDto = new MenuDto();

        menuDto.setAvailable(menuEntity.isAvailable());
        menuDto.setCategory(menuEntity.getCategory());
        menuDto.setDescription(menuEntity.getDescription());
        menuDto.setDiscount(menuEntity.getDiscount());
        menuDto.setPrice(menuEntity.getPrice());
        menuDto.setId(menuID);
        menuDto.setName(menuEntity.getName());

        return menuDto;
    }


    public void addMenu(MenuEntity menu) {
        menuHelper.addMenu(menu);
    }

    public boolean removeMenu(String menuId) throws MenuNotFound {
        return menuHelper.removeMenuById(menuId);
    }

}
