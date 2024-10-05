package springboot.spring_advanced1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.util.PatternMatchUtils;
import springboot.spring_advanced1.app.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import springboot.spring_advanced1.app.config.v2_dynamicproxy.DynamicProxyFilterConfig;

/*@Import({AppV1Config.class,AppV2Config.class})*/
/*@Import(InterfaceProxyConfig.class)*/
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "springboot.spring_advanced1.app.config")
public class SpringAdvanced1Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringAdvanced1Application.class, args);


    }
}
