package com.baizhi.entity;

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
public class Album implements Serializable {
    @Id
    private String id;
    private String title;
    private Integer count;
    @Column(name = "cover_img")
    private String coverImg;
    private Integer score;
    private String author;
    private String broadcast;
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Column(name = "pub_date")
    private Date pubDate;
    @Transient
    private List<Chapter> children;
}
