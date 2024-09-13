package springboot.spring_advanced1.app.proxy.v2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.spring_advanced1.app.proxy.v2.OrderControllerV2;
import springboot.spring_advanced1.app.proxy.v2.OrderServiceV2;
import springboot.spring_advanced1.app.proxy.v2.OrderRepositoryV2;

@Configuration
public class AppV2Config {
    @Bean
    public OrderControllerV2 orderControllerV2(){
        return new OrderControllerV2(orderServiceV2());
    }
    @Bean
    public OrderServiceV2 orderServiceV2(){
        return new OrderServiceV2(orderRepositoryV2());
    }
    @Bean
    public OrderRepositoryV2 orderRepositoryV2(){
        return new OrderRepositoryV2();
    }
}
