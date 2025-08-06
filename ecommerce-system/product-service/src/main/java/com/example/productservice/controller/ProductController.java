package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductMapper productMapper;
    private final StringRedisTemplate redisTemplate;

    @PostMapping
    public Product create(@RequestBody Product product) {
        productMapper.insert(product);
        redisTemplate.opsForValue().set("product:" + product.getId(), product.getName());
        return product;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        Product product = productMapper.selectById(id);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        return product;
    }
}