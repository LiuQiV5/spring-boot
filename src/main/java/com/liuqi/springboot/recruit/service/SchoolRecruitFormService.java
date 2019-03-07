package com.liuqi.springboot.recruit.service;

import com.liuqi.springboot.recruit.dao.SchoolRecruitFormDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolRecruitFormService {

    @Autowired
    private SchoolRecruitFormDao schoolRecruitFormDao;
}
