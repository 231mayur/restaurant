package net.menu.menuservice.controller;

import net.common.common_service.menu.MenuDto;
import net.menu.menuservice.advisor.exceptions.MenuNotFound;
import net.menu.menuservice.entity.MenuEntity;
import net.menu.menuservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping(path = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, MenuEntity> getAllMenu() {
        return menuService.getAllMenu();
    }

    @PostMapping(path = "/add",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addMenu(@RequestBody MenuEntity menu) {
        // add validation for menu
        menuService.addMenu(menu);
        return ResponseEntity.ok("Menu " + menu.getName() + " added!");
    }

    @GetMapping(path = "/menu/{menuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuDto getByMenuID(@PathVariable String menuId) throws MenuNotFound {
        return menuService.getByMenuID(menuId);
    }

    @DeleteMapping(path = "/remove")
    public ResponseEntity<String> removeMenu(@RequestParam("menuId") String menuId) throws MenuNotFound {
        if (menuService.removeMenu(menuId)) {
            return ResponseEntity.ok("Menu id " + menuId + " deleted!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
