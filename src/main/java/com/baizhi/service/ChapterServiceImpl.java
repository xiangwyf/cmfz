package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public void insertChapter(Chapter chapter) {
        chapter.setUploadDate(new Date());
        chapterMapper.insert(chapter);
    }

    @Override
    public Chapter queryOne(Integer id) {
        return chapterMapper.selectByPrimaryKey(id);
    }
}
