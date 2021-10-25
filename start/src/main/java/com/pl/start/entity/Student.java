package com.pll.start.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix = "student")
@Data
public class Student {
    private int id;
    private String name;
}
