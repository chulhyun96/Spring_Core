package springboot.spring_advanced1.app.proxy.v2;


public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepositoryV2;

    public OrderServiceV2(OrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }

    public void orderItem(String itemId) {
        orderRepositoryV2.save(itemId);
    }
}
