package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter")
public class Chapter implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Excel(name = "章节编号")
    private Integer id;
    @Excel(name="章节名")
    private String title;
    @Excel(name="章节大小")
    private String size;
    @Excel(name="章节时长")
    private String duration;
    @Excel(name="章节地址")
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @Column(name = "upload_date")
    @Excel(name="章节创建时间",format = "YYYY年MM月dd日")
    private Date uploadDate;
    @ExcelIgnore
    private String albumId;
    @ExcelIgnore
    @Transient
    private Album album;
}
