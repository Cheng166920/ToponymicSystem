package com.example.toponym.model;

import lombok.Data;

@Data

public class PointSite {
    /**
     * 数据库自增主键
     */
    private Long gid;
    private String 标识码;
    private String 图上名称;
    private String 类别代码;

    private String 使用时间;

    /**
     * 空间信息转换为字符串
     */
    private String geom;

}
