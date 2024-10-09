package springboot.spring_advanced1.beanpostprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanBasicTest {

    @Test
    @DisplayName("asd")
    void doTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BasicBeanConfig.class);
        A beanA = context.getBean("beanA", A.class);
        beanA.helloA();

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(B.class));
    }

    @TestConfiguration
    static class BasicBeanConfig {
        @Bean(name = "beanA")
        public A a () {
            return new A();
        }
    }
    @Slf4j
    static class A  {
        void helloA() {
            log.info("helloA");
        }
    }
    @Slf4j
    static class B {
        void helloB () {
            log.info("helloB");
        }
    }


}
