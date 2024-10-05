package springboot.spring_advanced1.app.config.v2_dynamicproxy.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springboot.spring_advanced1.trace.logtrace.LogTrace;
import springboot.spring_advanced1.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {
    /*`FieldLogTrace` 를 수동으로 스프링 빈으로 등록하자. 수동으로 등록하면 향후 구현체를 편리하게 변경할 수 있다는
        장점이 있다.*/
    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }

}
