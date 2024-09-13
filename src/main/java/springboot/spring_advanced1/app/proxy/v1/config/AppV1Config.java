package springboot.spring_advanced1.app.proxy.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.spring_advanced1.app.proxy.v1.*;

@Configuration
public class AppV1Config {
    @Bean
    public OrderControllerV1 orderControllerV1(){
        return new OrderControllerV1Impl(orderServiceV1());
    }
    @Bean
    public OrderServiceV1 orderServiceV1(){
        return new OrderServiceV1Impl(orderRepositoryV1());
    }
    @Bean
    public OrderRepositoryV1 orderRepositoryV1(){
        return new OrderRepositoryV1Impl();
    }

}
