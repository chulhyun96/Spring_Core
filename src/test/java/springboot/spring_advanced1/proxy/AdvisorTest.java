package springboot.spring_advanced1.proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import springboot.spring_advanced1.common.advice.TimeAdvice;
import springboot.spring_advanced1.common.service.ServiceImpl;
import springboot.spring_advanced1.common.service.ServiceInterface;

public class AdvisorTest {
    @Test
    @DisplayName("AdvisorTest1")
    void doTest() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }
}
