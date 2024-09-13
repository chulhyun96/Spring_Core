package springboot.spring_advanced1.app.proxy.v3;

import org.springframework.stereotype.Service;
import springboot.spring_advanced1.app.proxy.v2.OrderRepositoryV2;

@Service
public class OrderServiceV3 {
    private final OrderRepositoryV2 orderRepositoryV2;

    public OrderServiceV3(OrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }

    public void orderItem(String itemId) {
        orderRepositoryV2.save(itemId);
    }
}
