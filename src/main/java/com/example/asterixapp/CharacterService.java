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
}
