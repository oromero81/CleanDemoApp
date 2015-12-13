package com.oromero.cleandemoapp.presentation.mapper;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public interface CharacterPresentationMapper {

     CharacterPresentationModel transform(Character dataModel);

    List<CharacterPresentationModel> transform(List<Character> dataModels);

}
