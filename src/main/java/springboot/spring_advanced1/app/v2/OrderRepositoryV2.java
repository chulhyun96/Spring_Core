package springboot.spring_advanced1.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springboot.spring_advanced1.trace.TraceId;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.hellotrace.HelloTraceV2;


@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final HelloTraceV2 traceV2;

    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = traceV2.beginSync(traceId,"OrderRepository.save()");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);

            traceV2.end(status);
        } catch (Exception e) {
            traceV2.exception(status, e);
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
