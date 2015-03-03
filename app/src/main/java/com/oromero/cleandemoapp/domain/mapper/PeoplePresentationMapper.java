package com.oromero.cleandemoapp.domain.mapper;

import com.oromero.cleandemoapp.data.model.CharacterDataModel;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;

import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public interface PeoplePresentationMapper {

    public PeoplePresentationModel transform(CharacterDataModel dataModel);

    public List<PeoplePresentationModel> transform(List<CharacterDataModel> dataModels);

}
