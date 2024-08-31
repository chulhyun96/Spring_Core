package springboot.spring_advanced1.app.v4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.spring_advanced1.trace.TraceStatus;
import springboot.spring_advanced1.trace.logtrace.LogTrace;
import springboot.spring_advanced1.trace.template.AbstractTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 repositoryV4;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                repositoryV4.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.request()");
    }
}
