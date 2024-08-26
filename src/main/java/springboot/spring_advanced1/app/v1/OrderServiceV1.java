package springboot.spring_advanced1.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.hellotrace.HelloTraceV1;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 repositoryV1;
    private final HelloTraceV1 traceV1;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderController.request()");
            repositoryV1.save(itemId);
            traceV1.end(status);
        } catch (Exception e) {
            traceV1.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}
