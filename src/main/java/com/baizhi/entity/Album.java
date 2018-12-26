package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")
@ExcelTarget("Album")
public class Album implements Serializable {
    @Id
    @Excel(name = "编号",needMerge = true)
    private String id;
    @Excel(name = "标题",needMerge = true)
    private String title;
    @ExcelIgnore
    private Integer count;
    @Column(name = "cover_img")
    @Excel(name = "封面",type = 2, width = 40, height = 20,needMerge = true)
    private String coverImg;
    @Excel(name = "评分",needMerge = true)
    private Integer score;
    @Excel(name = "作者",needMerge = true)
    private String author;
    @Excel(name = "播音",needMerge = true)
    private String broadcast;
    @Excel(name = "评价",needMerge = true)
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Column(name = "pub_date")
    @Excel(name = "创建日期",format = "YYYY年MM月dd日", width = 20,needMerge = true)
    private Date pubDate;
    @Transient
    @ExcelCollection(name="音频")
    private List<Chapter> children;
}
