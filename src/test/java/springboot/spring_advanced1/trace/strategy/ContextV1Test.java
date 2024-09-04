package springboot.spring_advanced1.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.trace.strategy.code.*;

@Slf4j
public class ContextV1Test {

    @Test
    void strategy() {
        logic1();
        logic2();
    }
    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행

        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}",resultTime);
    }
    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("로직 실행2");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}",resultTime);
    }

    @Test
    void strategyMethodV1() {
        ContextV1 context1 = new ContextV1(new StrategyLogic1());
        context1.excecute();
        ContextV1 context2 = new ContextV1(new StrategyLogic2());
        context2.excecute();
    }
    @Test
    void strategyMethodV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.excecute(new StrategyLogic1());
        contextV2.excecute(new StrategyLogic2());
    }
}
