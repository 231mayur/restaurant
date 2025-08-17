package net.common.common_service.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ErrorException extends Exception
{
    private String message;
    private String errorCode;
    private LocalDateTime date;
    private String serviceName;

    public ErrorException(String message)
    {
        super(message);
        this.message = message;
    }
}
