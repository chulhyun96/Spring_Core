package springboot.spring_advanced1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springboot.spring_advanced1.app.proxy.config.v1_proxy.InterfaceProxyConfig;

/*@Import({AppV1Config.class,AppV2Config.class})*/
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "springboot.spring_advanced1.app.proxy")
public class SpringAdvanced1Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringAdvanced1Application.class, args);
    }
}
