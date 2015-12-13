package com.oromero.cleandemoapp.domain.mapper;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public interface CharacterPresentationMapper {

    public CharacterPresentationModel transform(Character dataModel);

    public List<CharacterPresentationModel> transform(List<Character> dataModels);

}
