package com.example.toponym.controller;

import com.example.toponym.model.PointSite;
import com.example.toponym.service.PointSiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController

@RequestMapping("/toponym/point")

public class PointSiteController {
    @Autowired
    private PointSiteService pointSiteService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/test01")
    public String testWay(){
        List list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String key = "test";
        redisTemplate.opsForValue().set(key,list.toString());
        return "success";
    }

    @GetMapping("/list")
    public List<PointSite> findAll(){
        return pointSiteService.findAll();
    }
}
