package springboot.spring_advanced1.strategy_practice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.spring_advanced1.strategy_practice.Grade;
import springboot.spring_advanced1.strategy_practice.Member;

@SpringBootTest
class DiscountServiceTest {
    @Autowired
    public DiscountService service;

    @Test
    void discountBronze() {
        // given
        Member bronzeMember = new Member("BronzeMember", Grade.BRONZE);
        // when
        int price = 3000;
        int discount = service.applyToDiscount(bronzeMember, price);
        // then
        Assertions.assertThat(discount).isEqualTo(price/10);
    }
    @Test
    void discountOverBronze() {
        // given
        Member goldMember = new Member("GoldMember", Grade.GOLD);
        // when
        int price = 5000;
        int discount = service.applyToDiscount(goldMember, price);
        // then
        Assertions.assertThat(discount).isEqualTo(price / 20);

    }

}