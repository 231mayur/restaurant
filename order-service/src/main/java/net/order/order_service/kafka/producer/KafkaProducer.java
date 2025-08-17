package net.order.order_service.kafka.producer;

import lombok.Getter;
import net.common.common_service.order.OrderDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    public final KafkaTemplate<String, OrderDto> kafkaTemplate;

    @Getter
    @Value("${resto.order.kafka.topic.name}")
    private String topic;

    @Value("${resto.order.kafka.groupid}")
    private String groupID;

    @Autowired
    KafkaProducer(KafkaTemplate<String, OrderDto> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrderDto orderDto)
    {
        Message<OrderDto> message = MessageBuilder.withPayload(orderDto)
                .setHeader(KafkaHeaders.TOPIC, topic.isBlank() ? "orders": topic)
                .setHeader(KafkaHeaders.GROUP_ID, groupID)
                .build();

        kafkaTemplate.send(message);
    }
}
