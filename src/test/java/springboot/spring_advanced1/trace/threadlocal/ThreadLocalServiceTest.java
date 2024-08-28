package springboot.spring_advanced1.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.trace.threadlocal.code.ThreadLocalFieldService;

@Slf4j
public class ThreadLocalServiceTest {
    private final ThreadLocalFieldService service = new ThreadLocalFieldService();
    @Test
    void field() {
        log.info("MAIN Thread start");
        Runnable userA = () -> {
            service.logic("userA");
        };
        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        threadB.start();
        sleep(2000); // 메인쓰레드 종료 대기. 얘가 없으면 threadB에 대한 결과가 출력되지 않고 그냥 끝나버린다.
        log.info("MAIN Thread end");
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
