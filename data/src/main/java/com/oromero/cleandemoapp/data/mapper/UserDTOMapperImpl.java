package com.oromero.cleandemoapp.data.mapper;

import com.oromero.cleandemoapp.data.model.ResultDTO;
import com.oromero.cleandemoapp.domain.entities.Character;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by oromero on 02/03/15.
 */
public class UserDTOMapperImpl implements UserDTOMapper {

    @Override
    public Character transform(ResultDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        Character character = new Character();

        character.setId(dto.getSeed());
        character.setFirstName(dto.getUser().getName().getFirst());
        character.setLastName(dto.getUser().getName().getLast());
        character.setGender(dto.getUser().getGender());
        character.setStreet(dto.getUser().getLocation().getStreet());
        character.setCity(dto.getUser().getLocation().getCity());
        character.setZip(dto.getUser().getLocation().getZip());
        character.setMail(dto.getUser().getEmail());
        character.setUsername(dto.getUser().getUsername());
        character.setPassword(dto.getUser().getPassword());
        character.setBirthday(new Date(Long.valueOf(dto.getUser().getDob()) * 1000));
        character.setPhone(dto.getUser().getPhone());
        character.setCell(dto.getUser().getCell());
        character.setPhotoLarge(dto.getUser().getPicture());
        character.setPhotoThumb(dto.getUser().getPicture().replace("http://api.randomuser.me/portraits/", "http://api.randomuser.me/portraits/med/"));

        return character;
    }

    @Override
    public List<Character> transform(List<ResultDTO> dtos) {
        List<Character> characters = new ArrayList<>();

        if (dtos != null && !dtos.isEmpty()) {
            for (ResultDTO resultDTO : dtos) {
                characters.add(transform(resultDTO));
            }
        }

        return characters;
    }
}