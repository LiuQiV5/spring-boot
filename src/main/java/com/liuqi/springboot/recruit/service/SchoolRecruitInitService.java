package com.liuqi.springboot.recruit.service;

import com.liuqi.springboot.recruit.basevo.FormVo;
import com.liuqi.springboot.recruit.basevo.InitVo;
import com.liuqi.springboot.recruit.basevo.NoticeVo;
import com.liuqi.springboot.recruit.dao.SchoolRecruitFormDao;
import com.liuqi.springboot.recruit.dao.SchoolRecruitInitDao;
import com.liuqi.springboot.recruit.dao.SchoolRecruitNoticeConfDao;
import com.liuqi.springboot.recruit.entity.SchoolRecruitForm;
import com.liuqi.springboot.recruit.entity.SchoolRecruitInit;
import com.liuqi.springboot.recruit.entity.SchoolRecruitNoticeConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolRecruitInitService {

    @Autowired
    private SchoolRecruitInitDao schoolRecruitInitDao;

    @Autowired
    private SchoolRecruitFormDao schoolRecruitFormDao;

    @Autowired
    private SchoolRecruitNoticeConfDao schoolRecruitNoticeConfDao;

    /**
     * 找出该校下的初始化内容
     * @param schoolguid
     * @return
     */
    public InitVo findBySchoolguid(String schoolguid){
        SchoolRecruitInit init = schoolRecruitInitDao.findBySchoolguid(schoolguid);

        InitVo initVo =  new InitVo();

        List<FormVo> formVos = new ArrayList<>(4);

        List<NoticeVo> noticeVos = new ArrayList<>(4);

        if (init!=null) {

            List<SchoolRecruitForm> forms = schoolRecruitFormDao.findByInitid(init.getId());

            List<SchoolRecruitNoticeConf> notices = schoolRecruitNoticeConfDao.findByInitid(init.getId());

            if(forms!=null && forms.size()>0) {
                for (SchoolRecruitForm form : forms) {
                    FormVo formVo = new FormVo(form.getId(),form.getModelpath(),form.getIndexpath(),form.getImgpath(),form.getName(),form.getModel());
                    formVos .add(formVo);
                }
            }

            if(notices!=null && notices.size()>0) {
                for (SchoolRecruitNoticeConf notice : notices) {
                    NoticeVo noticeVo = new NoticeVo(notice.getName(), notice.getType(), notice.getContent(), notice.getModelpath(), notice.getVisibility());
                    noticeVos.add(noticeVo);
                }
            }

            initVo.setDescription(init.getDescription());

            initVo.setGuide(init.getGuide());

            initVo.setExamination(init.getExamination());

            initVo.setNote(init.getNote());

            initVo.setForms(formVos);

            initVo.setNotices(noticeVos);
        }

        return initVo;
    }
}
