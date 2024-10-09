package springboot.spring_advanced1.beanpostprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Slf4j
public class ProxyTest {
    @Test
    @DisplayName("asd")
    void doTest1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Aservice.class);
        context.refresh();
        Aservice bean = context.getBean(Aservice.class);
        log.info("Aservice Bean = {}", bean.getClass());

    }
    @Test
    @DisplayName("test")
    void doTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProxyBean bean = context.getBean(ProxyBean.class);
        log.info("ProxyBean = {}", bean.getClass());
    }
    @Slf4j
    @Service
    static class Aservice {
    }
    @Slf4j
    @TestConfiguration
    static class Config {
        @Bean
        public ProxyBean proxyBean() {
            return new ProxyBean();
        }
    }
    @Slf4j
    static class ProxyBean {

    }

}
