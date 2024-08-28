package springboot.spring_advanced1.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.logtrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 repositoryV2;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.request()");
            repositoryV2.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}
