package com.oromero.cleandemoapp.data.mapper;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.data.model.ResultDTO;

import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public interface UserDTOMapper {

    Character transform(ResultDTO dto);

    List<Character> transform(List<ResultDTO> dtos);
}