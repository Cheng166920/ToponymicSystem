package com.example.toponym.service;

import com.example.toponym.model.PointSite;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PointSiteService {

    List<PointSite> findAll();
}
