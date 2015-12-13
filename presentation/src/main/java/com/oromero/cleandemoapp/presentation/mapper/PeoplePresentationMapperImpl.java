package com.oromero.cleandemoapp.presentation.mapper;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.presentation.model.PeoplePresentationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public class PeoplePresentationMapperImpl implements PeoplePresentationMapper {

    @Override
    public PeoplePresentationModel transform(Character dataModel) {
        if (dataModel == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        PeoplePresentationModel peoplePresentationModel = new PeoplePresentationModel();

        peoplePresentationModel.setId(dataModel.getId());
        peoplePresentationModel.setName(dataModel.getFirstName() + " " + dataModel.getLastName());
        peoplePresentationModel.setMail(dataModel.getMail());
        peoplePresentationModel.setImage(dataModel.getPhotoThumb());

        return peoplePresentationModel;
    }

    @Override
    public List<PeoplePresentationModel> transform(List<Character> dataModels) {
        List<PeoplePresentationModel> peoplePresentationModels = new ArrayList<>();

        if (dataModels != null && !dataModels.isEmpty()) {
            for (Character dataModel : dataModels) {
                peoplePresentationModels.add(transform(dataModel));
            }
        }

        return peoplePresentationModels;
    }
}