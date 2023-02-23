package com.soc.springkafka.countingmessages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KafkaCountingMessagesComponent {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    public static Map<String, Object> props = new HashMap<>();

    @PostConstruct
    public void init() {
        System.out.println(getTotalNumberOfMessagesInATopic("zeeshan"));
    }

    public Long getTotalNumberOfMessagesInATopic(String topic) {
    /*    org.apache.kafka.clients.consumer.KafkaConsumer<String, String> consumer=new org.apache.kafka.clients.consumer.KafkaConsumer<>(getProps());
        List<TopicPartition> partitions= consumer.partitionsFor(topic).stream
                .ma*/

        return 12L;
    }
}
