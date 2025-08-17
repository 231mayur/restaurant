package com.restaurant.advisor;

import com.restaurant.advisor.exceptions.RestaurantNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalAdvisor {


    @ExceptionHandler(value = RestaurantNotFound.class)
    public ResponseEntity<?> handleRestaurantNotFoundException(RestaurantNotFound ex) {
        return ResponseEntity.status(404).body(ex.getErrorMessage());
    }

}
