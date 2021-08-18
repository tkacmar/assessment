package com.ribs.api;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaConnectionHelper {

    public static final String JAAS_TEMPLATE = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
    private static final String KAFKA_BROKERS = "sulky-01.srvs.cloudkafka.com:9094,sulky-02.srvs.cloudkafka.com:9094,sulky-03.srvs.cloudkafka.com:9094";
    private static final String KAFKA_USERNAME = System.getProperty("kafka.username");
    private static final String KAFKA_PASSWORD = System.getProperty("kafka.password");

    public static Properties getKafkaProperties() {
        if(KAFKA_USERNAME == null || KAFKA_PASSWORD == null) {
            throw new IllegalArgumentException("Missing Kafka authentication properties. Please set 'kafka.username' and 'kafka.password' properties.");
        }
        String jaasCfg = String.format(JAAS_TEMPLATE, KAFKA_USERNAME, KAFKA_PASSWORD);
        String serializer = StringSerializer.class.getName();
        String deserializer = StringDeserializer.class.getName();
        Properties props = new Properties();
        props.put("bootstrap.servers", KAFKA_BROKERS);
        props.put("group.id", KAFKA_USERNAME + "-consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", deserializer);
        props.put("value.deserializer", deserializer);
        props.put("key.serializer", serializer);
        props.put("value.serializer", serializer);
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("sasl.jaas.config", jaasCfg);
        return props;
    }

    public static String getKafkaTopic(){
        return String.format("%s-default", KAFKA_USERNAME);
    }
}
