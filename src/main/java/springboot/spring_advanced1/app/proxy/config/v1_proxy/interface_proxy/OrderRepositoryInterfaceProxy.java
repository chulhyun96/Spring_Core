package springboot.spring_advanced1.app.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import springboot.spring_advanced1.app.proxy.v1.OrderRepositoryV1;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.logtrace.LogTrace;

@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {
    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.request()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }

    }
}
