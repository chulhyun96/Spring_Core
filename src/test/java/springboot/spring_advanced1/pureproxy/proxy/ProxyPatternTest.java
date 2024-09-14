package springboot.spring_advanced1.pureproxy.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.pureproxy.proxy.code.CacheProxy;
import springboot.spring_advanced1.pureproxy.proxy.code.ProxyPatternClient;
import springboot.spring_advanced1.pureproxy.proxy.code.RealSubject;
import springboot.spring_advanced1.pureproxy.proxy.code.Subject;

@Slf4j
public class ProxyPatternTest {
    @Test
    @DisplayName("프록시 적용 X")
    void noProxy() {
        long startTime = System.currentTimeMillis();
        Subject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
        log.info(("프록시 적용 X 시간 : " + (System.currentTimeMillis() - startTime)));
        // 총 3초 -> 해당 데이터를 캐시에 저장해야함.
    }
    @Test
    @DisplayName("프록시 적용 O")
    void doTest() {
        long startTime = System.currentTimeMillis();
        Subject subject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(subject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
        log.info("프록시 적용 O 시간 : {}", System.currentTimeMillis() - startTime);
    }
}
