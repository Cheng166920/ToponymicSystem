package com.example.toponym.controller;

import com.example.toponym.model.MapElement;
import com.example.toponym.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @program: postgresql
 * @description: map控制层
 * @author: zgr
 * @create: 2019-07-01 14:43
 **/
@Slf4j
@RestController

@RequestMapping("/toponym/test")
public class TestController {

    @Autowired
    private MapService mapService;

    /**
     * 添加地图元素
     * @param mapElement
     * @return 添加的地理元素信息
     */
    @PostMapping
    public MapElement addMapElement(@RequestBody MapElement mapElement){
        mapElement.setGeoStr(geometryToString(mapElement.getLongitude(), mapElement.getLatitude()));
        mapService.addMapElement(mapElement);
        Long id = mapElement.getId();
        return mapService.findById(id);
    }

    @GetMapping("/condition")
    public List<MapElement> findMapElementByCondition(MapElement mapElement){
        return mapService.findMapElementByCondition(mapElement);
    }

    /**
     * 查询全部信息
     * @return
     */
    @GetMapping("/list")
    public List<MapElement> findAll(){
        return mapService.findAll();
    }

    /**
     * @param id id
     * @return 是否删除成功
     */
    @DeleteMapping("/{id}")
    public Boolean deleteMapElement(@PathVariable Long id){
        Boolean deleteMapElementSuccess = true;
        try{
            mapService.deleteMapElement(id);
        }catch (Exception e){
            log.info("删除失败：" + e);
            deleteMapElementSuccess = false;
        }
        return deleteMapElementSuccess;
    }

    @PutMapping()
    public MapElement updateMapElement(@RequestBody MapElement mapElement){
        mapElement.setGeoStr(geometryToString(mapElement.getLongitude(), mapElement.getLatitude()));
        mapService.updateMapElement(mapElement);
        Long id = mapElement.getId();
        return mapService.findById(id);
    }

    private String geometryToString(double longitude, double latitude){
        String geoStr = "POINT" + "(" + longitude + " " + latitude + ")";
        return geoStr;
    }




}