package com.rabbitmq.producer.config;

import com.sib.co.contants.SibCoConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* @author: ThatND
* @since: 2/3/2023 4:44 PM
* @description:  Đoạn code này có ý nghĩa là chúng ta sẽ tạo ra một queue có tên là queue_name
*  một topic exchange tên là exchange_name và sẽ queue này sẽ được đăng kí nhận message từ exhange này qua ROUTING có partern rabbitmq.*
* @update:
*
* */
@Configuration
public class RabbitMQConfiguration {
    private static final String ROUTING_A = "routing_A";
    private static final String ROUTING_B = "routing_B";

    @Bean
    Queue queue() {
        return new Queue(SibCoConstant.QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(SibCoConstant.EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(SibCoConstant.ROUTING_KEY);
    }
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(SibCoConstant.QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MessageListener receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
