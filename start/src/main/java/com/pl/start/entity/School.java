package com.pll.start.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "school")
public class School {
    private List<Klass> klasses;
}
