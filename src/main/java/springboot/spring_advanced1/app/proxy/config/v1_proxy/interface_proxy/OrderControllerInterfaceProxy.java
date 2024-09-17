package springboot.spring_advanced1.app.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import springboot.spring_advanced1.app.proxy.v1.OrderControllerV1;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.logtrace.LogTrace;

@Slf4j
@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        //보안상 이슈로인해 로그를 남기면 안되는 메서드
        return target.noLog();
    }
}
