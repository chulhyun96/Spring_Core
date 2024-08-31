package springboot.spring_advanced1.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.trace.template.code.AbstractTemplate;
import springboot.spring_advanced1.trace.template.code.SubClassLogic1;
import springboot.spring_advanced1.trace.template.code.SubClassLogic2;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }
    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("로직 실행1");
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
    void templateMethodV1() {
        AbstractTemplate subClassLogic1 = new SubClassLogic1();
        SubClassLogic2 subClassLogic2 = new SubClassLogic2();
        subClassLogic1.execute();
        subClassLogic2.execute();
    }
    @Test
    void templateMethodV2() {
        AbstractTemplate anonymousClass1 = new AbstractTemplate() {
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        };
        anonymousClass1.execute();
        log.info("anonymousClass1 = {}", anonymousClass1.getClass());
        AbstractTemplate anonymousClass2 = new AbstractTemplate() {
            @Override
            public void call() {
                log.info("비즈니스 로직2");
            }
        };
        anonymousClass2.execute();
        log.info("anonymousClass2 = {}", anonymousClass2.getClass());
    }
}
