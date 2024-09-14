package springboot.spring_advanced1.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{
    // 캐쉬 기능의 프록시
    // RealSubject에 접근할 수 있어야함.
    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    //캐쉬 기능
    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = target.operation(); // null일 경우 Subject 인터페이스를 통해 실제 객체 호출
            // null이 아닐 경우 실제 객체를 호출하지 않음. 따라서 처음 조회 이후에는 빠르게 데이터 조회 가능
        }
        return cacheValue;
    }
}
