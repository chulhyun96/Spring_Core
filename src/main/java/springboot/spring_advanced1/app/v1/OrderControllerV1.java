package springboot.spring_advanced1.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.hellotrace.HelloTraceV1;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderService;
    private final HelloTraceV1 traceV1;

    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = traceV1.begin("OrderController.request()");
            orderService.orderItem(itemId);
            traceV1.end(status);
            return "ok";
        } catch (Exception e) {
            traceV1.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }
    }
}
