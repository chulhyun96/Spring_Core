package springboot.spring_advanced1.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.function.Supplier;

@Slf4j
public class ReflectionTest {

    @Test
    @DisplayName("reflection0")
    void reflection0() {
        Hello target = new Hello();

        executeLogging(target::callA);
        executeLogging(target::callB);
    }

    private void executeLogging(Supplier<String> method){
        log.info("start");
        String result1 = method.get();
        log.info("result :{}", result1);

    }
    @Test
    @DisplayName("")
    void reflection1() throws Exception {
        /*클래스의 메타 정볼를 먼저 얻고, 메서드의 정볼를 얻어온다*/
        String method = "callA";
        Class<?> aClass = Class.forName("springboot.spring_advanced1.jdkdynamic.ReflectionTest$Hello");
        Hello hello = new Hello();
        Method callA = aClass.getMethod(method);
        dynamicCall(callA, hello);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object result = method.invoke(target);// 차이
        log.info("result:{}", result);
    }

    @Slf4j
    static class Hello{
        public String callA() {
            log.info("callA");
            return "A";
        }
        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
