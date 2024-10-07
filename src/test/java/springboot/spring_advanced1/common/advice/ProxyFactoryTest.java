package springboot.spring_advanced1.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import springboot.spring_advanced1.common.service.ConcreteService;
import springboot.spring_advanced1.common.service.ServiceImpl;
import springboot.spring_advanced1.common.service.ServiceInterface;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class ProxyFactoryTest {
    @Test
    @DisplayName("인터페이스 기반 클래스 사용시 JDK 동적 프록시 사용")
    void doTest() {
        ServiceImpl serviceImpl = new ServiceImpl();

        ProxyFactory proxy = new ProxyFactory(serviceImpl);
        proxy.addAdvice(new TimeAdvice());

        ServiceInterface service = (ServiceInterface) proxy.getProxy();

        log.info("targetClass={}", serviceImpl.getClass());
        log.info("proxyClass={}", service.getClass());

        service.save();

        assertThat(AopUtils.isAopProxy(service)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(service)).isTrue();
        assertThat(AopUtils.isCglibProxy(service)).isFalse();
    }
    @Test
    @DisplayName("구체클래스 사용시 CGLIB 프록시 사용")
    void doTest1() {
        ConcreteService serviceImpl = new ConcreteService();

        ProxyFactory proxy = new ProxyFactory(serviceImpl);
        proxy.addAdvice(new TimeAdvice());

        ConcreteService service = (ConcreteService) proxy.getProxy();

        log.info("targetClass={}", serviceImpl.getClass());
        log.info("proxyClass={}", service.getClass());

        service.call();

        assertThat(AopUtils.isAopProxy(service)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(service)).isFalse();
        assertThat(AopUtils.isCglibProxy(service)).isTrue();
    }
    @Test
    @DisplayName("ProxyTargetClass 옵션을 사용하여 인터페이스가 있어도 CGLIB를 사용해야 할 경우")
    void doTest2() {
        ServiceImpl serviceImpl = new ServiceImpl();

        ProxyFactory proxy = new ProxyFactory(serviceImpl);
        proxy.setProxyTargetClass(true);

        proxy.addAdvice(new TimeAdvice());
        ServiceImpl service = (ServiceImpl) proxy.getProxy();

        log.info("targetClass={}", serviceImpl.getClass());
        log.info("proxyClass={}", service.getClass());

        service.save();

        assertThat(AopUtils.isAopProxy(service)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(service)).isFalse();
        assertThat(AopUtils.isCglibProxy(service)).isTrue();
    }
}
