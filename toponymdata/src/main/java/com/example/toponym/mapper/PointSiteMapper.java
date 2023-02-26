package com.example.toponym.mapper;

import com.example.toponym.model.PointSite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface PointSiteMapper {
    /**
     * @return 返回全部的mapElement
     */
    List<PointSite> findAll();

}
