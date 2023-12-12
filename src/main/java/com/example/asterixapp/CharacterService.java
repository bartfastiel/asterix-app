package com.example.asterixapp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository repo;

    public CharacterService(CharacterRepository repo) {
        this.repo = repo;
    }

    public List<Character> findAll() {
        return repo.findAll();
    }

    public int getNumberOfSmallCharacters() {
        List<Character> allCharacters = repo.findAll();

        int numberOfSmallCharacters = 0;
        for (Character character : allCharacters) {
            if (character.description().contains("klein")) {
                numberOfSmallCharacters++;
            }
        }
        return numberOfSmallCharacters;
    }

    public Character save(String id, NewCharacter newCharacter) {
        Character toSave = new Character(id, newCharacter.name(), newCharacter.description());
        return repo.save(toSave);
    }
}
