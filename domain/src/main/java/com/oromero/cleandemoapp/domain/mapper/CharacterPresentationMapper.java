package com.oromero.cleandemoapp.domain.mapper;

import com.oromero.cleandemoapp.domain.entities.CharacterDataModel;
import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public interface CharacterPresentationMapper {

    public CharacterPresentationModel transform(CharacterDataModel dataModel);

    public List<CharacterPresentationModel> transform(List<CharacterDataModel> dataModels);

}
