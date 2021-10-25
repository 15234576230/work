package com.pll.start.config;

import com.pll.start.entity.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableConfigurationProperties(Student.class)
@ConditionalOnProperty(
        prefix = "student",
        name = "isopen",
        havingValue = "true"
)
public class StudentConfig {
}
