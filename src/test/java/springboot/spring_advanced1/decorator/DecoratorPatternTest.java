package springboot.spring_advanced1.decorator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springboot.spring_advanced1.decorator.code.*;

public class DecoratorPatternTest {
    @Test
    @DisplayName("데코레이터 패턴 적용 X")
    void noDecorator() {
        Component component = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(component);
        client.execute();
        client.execute();
        client.execute();
    }
    @Test
    @DisplayName("")
    void messageDecorator() {
        //given
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }
    @Test
    @DisplayName("")
    void timeDecorator() {
        //given
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
