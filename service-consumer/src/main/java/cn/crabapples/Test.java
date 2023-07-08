package cn.crabapples;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "test")
@Getter
@Setter
@Component
public class Test {
    private String name;
    private Integer age;
    private String gender;
}
