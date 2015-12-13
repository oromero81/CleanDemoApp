package com.oromero.cleandemoapp.presentation.mapper;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public interface PeoplePresentationMapper {

    PeoplePresentationModel transform(Character dataModel);

    List<PeoplePresentationModel> transform(List<Character> dataModels);

}
