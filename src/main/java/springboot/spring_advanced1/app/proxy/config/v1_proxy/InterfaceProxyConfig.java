package springboot.spring_advanced1.app.proxy.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.spring_advanced1.app.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import springboot.spring_advanced1.app.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import springboot.spring_advanced1.app.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import springboot.spring_advanced1.app.proxy.v1.*;
import springboot.spring_advanced1.trace.logtrace.LogTrace;
import springboot.spring_advanced1.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace){
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }
    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace){
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }
    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace){
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
