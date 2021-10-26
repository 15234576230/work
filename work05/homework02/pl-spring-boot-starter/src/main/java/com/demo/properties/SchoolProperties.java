package com.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private List<KlassProperties> klasses;

}
