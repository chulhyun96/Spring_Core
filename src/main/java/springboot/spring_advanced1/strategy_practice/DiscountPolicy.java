package springboot.spring_advanced1.strategy_practice;


public interface DiscountPolicy {
    int discount(Member member, int price);
}
