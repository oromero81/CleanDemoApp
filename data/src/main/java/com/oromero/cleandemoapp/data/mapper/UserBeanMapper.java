package com.oromero.cleandemoapp.data.mapper;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.data.model.ResultDTO;

import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public interface UserBeanMapper {

    public Character transform(ResultDTO bean);

    public List<Character> transform(List<ResultDTO> beans);
}
