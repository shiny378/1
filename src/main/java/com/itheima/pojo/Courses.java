package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private Integer id;
    private String name;
    private int hours;
    private String schools;
    private String pic;
}