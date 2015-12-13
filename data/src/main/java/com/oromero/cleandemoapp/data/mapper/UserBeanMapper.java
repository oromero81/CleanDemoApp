package com.oromero.cleandemoapp.data.mapper;

import com.oromero.cleandemoapp.domain.entities.CharacterDataModel;
import com.oromero.cleandemoapp.data.model.bean.ResultBean;

import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public interface UserBeanMapper {

    public CharacterDataModel transform(ResultBean bean);

    public List<CharacterDataModel> transform(List<ResultBean> beans);
}
