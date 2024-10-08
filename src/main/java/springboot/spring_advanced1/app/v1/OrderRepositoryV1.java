package springboot.spring_advanced1.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.hellotrace.HelloTraceV1;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 traceV1;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderRepository.save()");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);

            traceV1.end(status);
        } catch (Exception e) {
            traceV1.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
