package springboot.spring_advanced1.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface{
    @Override
    public String call() {
        log.info("AImpl call");
        return "A";
    }
}
