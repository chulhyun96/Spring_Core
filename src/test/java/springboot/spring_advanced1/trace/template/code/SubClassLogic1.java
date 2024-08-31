package springboot.spring_advanced1.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate {
    @Override
    public void call() {
        log.info("SubClassLogic1 call");
    }
}
