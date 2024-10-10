package springboot.spring_advanced1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import springboot.spring_advanced1.app.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import springboot.spring_advanced1.testconfig.MemberConfig;
import springboot.spring_advanced1.testconfig.MemberRepositroy;
import springboot.spring_advanced1.testconfig.MemberService;
import springboot.spring_advanced1.testconfig.OrderService;

/*@Import({AppV1Config.class,AppV2Config.class})*/
/*@Import(InterfaceProxyConfig.class)*/
@Slf4j
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "springboot.spring_advanced1.app.config")
public class SpringAdvanced1Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringAdvanced1Application.class, args);
    }
}
