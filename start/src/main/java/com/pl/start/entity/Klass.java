package com.pll.start.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "klass")
public class Klass {
    private List<Student> students;
}
