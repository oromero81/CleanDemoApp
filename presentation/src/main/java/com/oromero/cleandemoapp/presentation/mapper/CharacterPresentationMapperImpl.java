package com.oromero.cleandemoapp.presentation.mapper;

import com.oromero.cleandemoapp.domain.entities.Character;
import com.oromero.cleandemoapp.presentation.model.CharacterPresentationModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oromero on 03/03/15.
 */
public class CharacterPresentationMapperImpl implements CharacterPresentationMapper {

    @Override
    public CharacterPresentationModel transform(Character dataModel) {
        if (dataModel == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        CharacterPresentationModel characterPresentationModel = new CharacterPresentationModel();

        characterPresentationModel.setName(dataModel.getFirstName() + " " + dataModel.getLastName());
        characterPresentationModel.setImage(dataModel.getPhotoLarge());
        characterPresentationModel.setMail(dataModel.getMail());
        characterPresentationModel.setUsername(dataModel.getUsername());
        characterPresentationModel.setPassword(dataModel.getPassword());
        characterPresentationModel.setAddress(dataModel.getStreet() + " " + dataModel.getZip() + " - " + dataModel.getCity());
        characterPresentationModel.setPhone(dataModel.getPhone());
        characterPresentationModel.setCell(dataModel.getCell());
        characterPresentationModel.setBirthday(new SimpleDateFormat("dd/MM/yyyy").format(dataModel.getBirthday()));

        return characterPresentationModel;
    }

    @Override
    public List<CharacterPresentationModel> transform(List<Character> dataModels) {
        List<CharacterPresentationModel> characterPresentationModels = new ArrayList<>();

        if (dataModels != null && !dataModels.isEmpty()) {
            for (Character dataModel : dataModels) {
                characterPresentationModels.add(transform(dataModel));
            }
        }

        return characterPresentationModels;
    }
}