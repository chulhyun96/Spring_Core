package springboot.spring_advanced1.trace.strategy.collback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate{
    public void excecute(Callback callback) {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        callback.call();
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}",resultTime);
    }
}
