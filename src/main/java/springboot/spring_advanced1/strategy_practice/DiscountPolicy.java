package springboot.spring_advanced1.strategy_practice;


public interface DiscountPolicy {
    DiscountType getDiscountType();
    int discount(Member member, int price);
}
