package springboot.spring_advanced1.trace.strategy.collback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TimeLogTemplateTest {
    @Test
    void callbackTest() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.excecute(new Callback() {
            @Override
            public void call() {
                log.info("callback pattern 1");
            }
        });
        timeLogTemplate.excecute(() -> log.info("callback pattern 2"));
        timeLogTemplate.excecute(() -> log.info("callback pattern 3"));
    }

}
