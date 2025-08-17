package com.restaurant.advisor.exceptions;

import com.restaurant.advisor.ErrorMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantNotFound extends Exception
{
    private ErrorMessage errorMessage;

    public RestaurantNotFound(String id,String message) {
        super(message);
        errorMessage = new ErrorMessage(id, message);
    }
}
