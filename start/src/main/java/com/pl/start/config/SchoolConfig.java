package com.pll.start.config;

import com.pll.start.entity.School;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableConfigurationProperties(School.class)
@ConditionalOnProperty(
        prefix = "student",
        name = "isopen",
        havingValue = "true"
)
public class SchoolConfig {
}
