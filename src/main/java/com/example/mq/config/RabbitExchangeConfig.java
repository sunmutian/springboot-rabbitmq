package com.example.mq.config;

import com.example.mq.util.RabbitConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianweichang
 * @date 2018-05-08 11:49
 **/
@Configuration
public class RabbitExchangeConfig {
    //直连交换机
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(RabbitConstant.EXCHANGE_NAME);
    }

    //队列
    @Bean
    public Queue queue() {
        return QueueBuilder.durable(RabbitConstant.QUEUE_NAME).build();
    }

    //绑定
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(this.queue()).to(this.defaultExchange()).with(RabbitConstant.ROUTING_KEY);
    }
}
