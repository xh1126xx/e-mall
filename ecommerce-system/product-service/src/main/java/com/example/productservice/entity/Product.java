package com.example.productservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("product")
@Data
public class Product {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
}