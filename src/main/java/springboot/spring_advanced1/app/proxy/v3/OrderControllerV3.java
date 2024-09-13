package springboot.spring_advanced1.app.proxy.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.spring_advanced1.app.proxy.v2.OrderServiceV2;

@Slf4j
@RestController
public class OrderControllerV3 {
    private final OrderServiceV2 orderServiceV2;

    public OrderControllerV3(OrderServiceV2 orderServiceV2) {
        this.orderServiceV2 = orderServiceV2;
    }

    @GetMapping("/v3/request")
    public String request(String itemId) {
        log.info("Order Controller V3 호출");
        orderServiceV2.orderItem(itemId);
        return "ok";
    }
    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
