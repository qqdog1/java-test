package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.component.ArbitraryDependency;
import spring.component.YetAnotherArbitraryDependency;

@Configuration
public class ApplicationContextTestInjectName {

    @Bean
    public ArbitraryDependency yetAnotherFieldInjectDependency() {
        ArbitraryDependency yetAnotherFieldInjectDependency =
          new YetAnotherArbitraryDependency();
        return yetAnotherFieldInjectDependency;
    }
}
