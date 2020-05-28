package com.aaa.hgspringbootmybatis.entity;

import lombok.Data;

import java.util.List;


@Data
public class LayUITable {
    private int code;
    private String msg;
    private long count;
    private List<?> data;
}
