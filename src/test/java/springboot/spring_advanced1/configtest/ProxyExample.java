package springboot.spring_advanced1.configtest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.spring_advanced1.beanpostprocessor.ProxyTest;

@Slf4j
public class ProxyExample {
    @Test
    @DisplayName("test1")
    void doTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProxyBean1 bean = context.getBean(ProxyBean1.class);
        log.info("bean: {}", bean.getClass());

    }
    @Configuration
    static class Config {
        @Bean
        public ProxyBean1 proxyBean() {
            return new ProxyBean1();
        }
    }
    static class ProxyBean1 {

    }
}
