package springboot.spring_advanced1.trace.logtrace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.spring_advanced1.trace.TraceStatus;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus test1 = trace.begin("test1");
        TraceStatus test2 = trace.begin("test2");
        trace.end(test1);
        trace.end(test2);
    }
}