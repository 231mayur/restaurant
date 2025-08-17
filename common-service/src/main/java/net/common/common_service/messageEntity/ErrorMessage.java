package net.common.common_service.messageEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage
{
    private String message;
    private String serviceName;
}
