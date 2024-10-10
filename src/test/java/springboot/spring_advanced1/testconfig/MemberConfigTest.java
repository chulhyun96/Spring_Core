package springboot.spring_advanced1.testconfig;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberConfigTest {

    @Test
    @DisplayName("Test Member Config")
    void doTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MemberConfig.class);

        //한번
        MemberService memberService = context.getBean("memberService", MemberService.class);
        MemberRepositroy memberRepository = memberService.getMemberRepositroy();

        MemberRepositroy getBeanRepository = context.getBean("memberRepository", MemberRepositroy.class);

        //두번
        OrderService orderService = context.getBean("orderService", OrderService.class);
        MemberRepositroy orderMemberRep = orderService.getMemberRepositroy();
        log.info("MemberService {}", memberService);

        // 얘네 둘은 같은 인스턴스
        log.info("MemberRepository = {}", memberRepository);
        log.info("getBeanRepository = {}", getBeanRepository);
        log.info("orderService = {}", orderMemberRep);
    }

    @Test
    void test(){
        MemberConfig bean = new AnnotationConfigApplicationContext(MemberConfig.class).getBean(MemberConfig.class);
        log.info("bean = {}", bean);
    }

}