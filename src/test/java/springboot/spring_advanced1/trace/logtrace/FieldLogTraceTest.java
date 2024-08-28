package springboot.spring_advanced1.trace.logtrace;

import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.trace.TraceStatus;


class FieldLogTraceTest {
    @Test
    void begin_end_level2() {
        FieldLogTrace trace = new FieldLogTrace();
        TraceStatus test1 = trace.begin("test1");
        TraceStatus test2 = trace.begin("test2");
        TraceStatus test3 = trace.begin("test3");
        trace.end(test1);
        trace.end(test2);
        trace.end(test3);
    }
}