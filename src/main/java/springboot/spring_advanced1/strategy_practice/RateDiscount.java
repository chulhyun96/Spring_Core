package springboot.spring_advanced1.strategy_practice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RateDiscount implements DiscountPolicy{
    @Override
    public int discount(Member member, int price) {
        Grade grade = member.getGrade();
        int rate = 0;
        switch (grade) {
            case SILVER -> rate = 15;
            case GOLD -> rate = 20;
        }
        return price / rate;
    }
}
