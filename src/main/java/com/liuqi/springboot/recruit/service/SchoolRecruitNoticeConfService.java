package com.liuqi.springboot.recruit.service;

import com.liuqi.springboot.recruit.dao.SchoolRecruitNoticeConfDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolRecruitNoticeConfService {

    @Autowired
    private SchoolRecruitNoticeConfDao schoolRecruitNoticeConfDao;
}
