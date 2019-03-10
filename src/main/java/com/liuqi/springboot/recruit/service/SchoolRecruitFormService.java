package com.liuqi.springboot.recruit.service;

import com.liuqi.springboot.recruit.basevo.FormVo;
import com.liuqi.springboot.recruit.dao.SchoolRecruitFormDao;
import com.liuqi.springboot.recruit.entity.SchoolRecruitForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolRecruitFormService {

    @Autowired
    private SchoolRecruitFormDao schoolRecruitFormDao;

    /**
     * 根据学校查询所有的表单模板
     * @param schoolguid
     * @return
     */
    public List<FormVo> findFormBySchoolguid(String schoolguid){
        List<FormVo> formVos = new ArrayList<>(10);

        List<SchoolRecruitForm> forms = schoolRecruitFormDao.findBySchoolguid(schoolguid);
        if(forms!=null && forms.size()>0) {
            for (SchoolRecruitForm form : forms) {
                FormVo vo = new FormVo();
                BeanUtils.copyProperties(form,vo);
                formVos.add(vo);
            }
        }
        return formVos;
    }
}
