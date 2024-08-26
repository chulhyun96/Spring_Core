package springboot.spring_advanced1.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.spring_advanced1.trace.TraceId;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.hellotrace.HelloTraceV2;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 repositoryV2;
    private final HelloTraceV2 traceV2;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = traceV2.beginSync(traceId,"OrderController.request()");
            repositoryV2.save(status.getTraceId(),itemId);
            traceV2.end(status);
        } catch (Exception e) {
            traceV2.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}
