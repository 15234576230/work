package com.pll.start.config;

import com.pll.start.entity.Klass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableConfigurationProperties(Klass.class)
@ConditionalOnProperty(
        prefix = "student",
        name = "isopen",
        havingValue = "true"
)
public class KlassConfig {
}
