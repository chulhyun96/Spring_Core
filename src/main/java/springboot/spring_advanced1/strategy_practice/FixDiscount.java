package springboot.spring_advanced1.strategy_practice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
public class FixDiscount implements DiscountPolicy {
    @Override
    public DiscountType getDiscountType() {
        return DiscountType.FIX;
    }

    @Override
    public int discount(Member member, int price) {
        return price / 10;
    }
}
