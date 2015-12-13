package com.oromero.cleandemoapp.data.mapper;

import com.oromero.cleandemoapp.data.model.ResultDTO;
import com.oromero.cleandemoapp.domain.entities.Character;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public class UserBeanMapperImpl implements UserBeanMapper {

    @Override
    public Character transform(ResultDTO bean) {
        if (bean == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        Character character = new Character();

        character.setId(bean.getSeed());
        character.setFirstName(bean.getUser().getName().getFirst());
        character.setLastName(bean.getUser().getName().getLast());
        character.setGender(bean.getUser().getGender());
        character.setStreet(bean.getUser().getLocation().getStreet());
        character.setCity(bean.getUser().getLocation().getCity());
        character.setZip(bean.getUser().getLocation().getZip());
        character.setMail(bean.getUser().getEmail());
        character.setUsername(bean.getUser().getUsername());
        character.setPassword(bean.getUser().getPassword());
        character.setBirthday(new Date(Long.valueOf(bean.getUser().getDob()) * 1000));
        character.setPhone(bean.getUser().getPhone());
        character.setCell(bean.getUser().getCell());
        character.setPhotoLarge(bean.getUser().getPicture());
        character.setPhotoThumb(bean.getUser().getPicture().replace("http://api.randomuser.me/portraits/", "http://api.randomuser.me/portraits/med/"));

        return character;
    }

    @Override
    public List<Character> transform(List<ResultDTO> beans) {
        List<Character> characters = new ArrayList<>();

        if (beans != null && !beans.isEmpty()) {
            for (ResultDTO resultDTO : beans) {
                characters.add(transform(resultDTO));
            }
        }

        return characters;
    }
}
