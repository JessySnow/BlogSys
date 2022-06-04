package com.jessysnow.boot.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    private int id;
    private String value;
}
