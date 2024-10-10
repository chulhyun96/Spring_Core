package springboot.spring_advanced1.testconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepositroy memberRepository() {
        System.out.println("싱글톤 테스트 = MemberConfig.memberRepository");
        return new MemberRepositroy();
    }
    @Bean
    public OrderService orderService() {
        return new OrderService(memberRepository());
    }

}
