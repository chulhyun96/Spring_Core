package springboot.spring_advanced1.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.trace.threadlocal.code.FieldService;

@Slf4j
public class FieldServiceTest {
    private final FieldService fieldService = new FieldService();
    @Test
    void field() {
        log.info("MAIN Thread start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };
        Runnable userB = new Runnable() {
            @Override
            public void run() {
                fieldService.logic("userB");
            }
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(2000);
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
