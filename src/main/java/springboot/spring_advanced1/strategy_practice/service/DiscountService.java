package springboot.spring_advanced1.strategy_practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.spring_advanced1.strategy_practice.DiscountPolicy;
import springboot.spring_advanced1.strategy_practice.Grade;
import springboot.spring_advanced1.strategy_practice.Member;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final Map<String, DiscountPolicy> discountPolicyMap;

    public int applyToDiscount(Member member, int price) {
        Grade grade = member.getGrade();
        if (grade.equals(Grade.BRONZE)) {
            return discountPolicyMap.get("fixDiscount").discount(member,price);
        }
        return discountPolicyMap.get("rateDiscount").discount(member,price);
    }
}
