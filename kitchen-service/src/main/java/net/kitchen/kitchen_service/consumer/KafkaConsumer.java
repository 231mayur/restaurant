package net.kitchen.kitchen_service.consumer;

import net.common.common_service.order.OrderDto;
import net.kitchen.kitchen_service.service.KitchenHelper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "${resto.order.kafka.topic.name}", groupId = "${resto.order.kafka.groupid}")
    public void topicListener(OrderDto orderDto)
    {
        // log the event kibana, elastic search to log
        KitchenHelper.putOrder(orderDto);
    }
}
