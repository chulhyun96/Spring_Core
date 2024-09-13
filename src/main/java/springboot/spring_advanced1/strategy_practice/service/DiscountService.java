package springboot.spring_advanced1.strategy_practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.spring_advanced1.strategy_practice.DiscountPolicy;
import springboot.spring_advanced1.strategy_practice.DiscountType;
import springboot.spring_advanced1.strategy_practice.Grade;
import springboot.spring_advanced1.strategy_practice.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final Map<String, DiscountPolicy> discountPolicyMap;


    public int applyToDiscount(Member member, int price) {
        return (member.getGrade() == Grade.BRONZE) ?
                discountPolicyMap.get("fixDiscount").discount(member,price) :
                discountPolicyMap.get("rateDiscount").discount(member,price);
    }
}
