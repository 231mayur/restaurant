package net.menu.menuservice.advisor.exceptions;

import net.common.common_service.exception.ErrorException;

public class MenuNotFound extends ErrorException
{
    public MenuNotFound(String errorMessage)
    {
        super(errorMessage);
    }
}
