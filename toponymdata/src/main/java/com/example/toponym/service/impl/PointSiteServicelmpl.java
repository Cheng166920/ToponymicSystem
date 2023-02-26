package com.example.toponym.service.impl;

import com.example.toponym.mapper.PointSiteMapper;
import com.example.toponym.model.PointSite;
import com.example.toponym.service.PointSiteService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PointSiteServicelmpl implements PointSiteService {

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Autowired
        private PointSiteMapper pointSiteMapper;

        @Override
        public List<PointSite> findAll() {
            return pointSiteMapper.findAll();
        }

}
