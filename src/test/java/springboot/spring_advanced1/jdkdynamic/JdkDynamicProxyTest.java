package springboot.spring_advanced1.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.jdkdynamic.code.AImpl;
import springboot.spring_advanced1.jdkdynamic.code.AInterface;
import springboot.spring_advanced1.jdkdynamic.code.TimeInvocationHandler;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    @DisplayName("")
    void dynamicProxyA() {
        // 타겟 생성 및 인터페이스의 구현체 생성
        AInterface target = new AImpl(); // 실제 로직 호출할 타겟
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(target); // ProxyInterface

        AInterface proxy = (AInterface) Proxy.newProxyInstance(
                AInterface.class.getClassLoader(), new Class[]{AInterface.class}, timeInvocationHandler);

        proxy.call();
        log.info("TargetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
