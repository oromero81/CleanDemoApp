package com.oromero.cleandemoapp.domain.interactor;

import com.oromero.cleandemoapp.domain.repository.CharacterRepository;

import java.io.IOException;

/**
 * Created by oromero on 03/03/15.
 */
public class CharacterInteractor implements Interactor {

    private Buzzer buzzer;
    private CharacterRepository characterRepository;

    private String id;

    public CharacterInteractor(Buzzer buzzer, CharacterRepository characterRepository) {
        this.buzzer = buzzer;
        this.characterRepository = characterRepository;
    }

    public void setup(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            buzzer.broadcastEvent(characterRepository.getCharacter(id));
        } catch (IOException e) {
//            buzzer.broadcastEvent(error);
        }
    }
}