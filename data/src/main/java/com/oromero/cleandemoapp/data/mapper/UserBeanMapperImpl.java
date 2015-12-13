package com.oromero.cleandemoapp.data.mapper;

import com.oromero.cleandemoapp.domain.entities.CharacterDataModel;
import com.oromero.cleandemoapp.data.model.bean.ResultBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by oromero on 02/03/15.
 */
public class UserBeanMapperImpl implements UserBeanMapper {

    @Inject
    public UserBeanMapperImpl() {
    }

    @Override
    public CharacterDataModel transform(ResultBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        CharacterDataModel characterDataModel = new CharacterDataModel();

        characterDataModel.setId(bean.getSeed());
        characterDataModel.setFirstName(bean.getUser().getName().getFirst());
        characterDataModel.setLastName(bean.getUser().getName().getLast());
        characterDataModel.setGender(bean.getUser().getGender());
        characterDataModel.setStreet(bean.getUser().getLocation().getStreet());
        characterDataModel.setCity(bean.getUser().getLocation().getCity());
        characterDataModel.setZip(bean.getUser().getLocation().getZip());
        characterDataModel.setMail(bean.getUser().getEmail());
        characterDataModel.setUsername(bean.getUser().getUsername());
        characterDataModel.setPassword(bean.getUser().getPassword());
        characterDataModel.setBirthday(new Date(Long.valueOf(bean.getUser().getDob()) * 1000));
        characterDataModel.setPhone(bean.getUser().getPhone());
        characterDataModel.setCell(bean.getUser().getCell());
        characterDataModel.setPhotoLarge(bean.getUser().getPicture());
        characterDataModel.setPhotoThumb(bean.getUser().getPicture().replace("http://api.randomuser.me/portraits/", "http://api.randomuser.me/portraits/med/"));

        return characterDataModel;
    }

    @Override
    public List<CharacterDataModel> transform(List<ResultBean> beans) {
        List<CharacterDataModel> characterDataModels = new ArrayList<>();

        if (beans != null && !beans.isEmpty()) {
            for (ResultBean resultBean : beans) {
                characterDataModels.add(transform(resultBean));
            }
        }

        return characterDataModels;
    }
}
