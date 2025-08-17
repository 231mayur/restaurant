package net.menu.menuservice.advisor;

import net.common.common_service.messageEntity.ErrorMessage;
import net.menu.menuservice.advisor.exceptions.MenuNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalAdvisor {

    private final String MENUSERVICENAME = "MENU-SERVICE";

    @ExceptionHandler(MenuNotFound.class)
    public ResponseEntity<ErrorMessage> globalMenuNotFound(MenuNotFound menuNotFound)
    {

        menuNotFound.setServiceName(MENUSERVICENAME);
        menuNotFound.setErrorCode(HttpStatus.NOT_FOUND.toString());
        menuNotFound.setDate(LocalDateTime.now());
        // log menu not found exception

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setServiceName(MENUSERVICENAME);
        errorMessage.setMessage(menuNotFound.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
