package com.pl.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String name;
    private double money;

    public Account(String name, int i) {
    }
}
