package com.example.asterixapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService service;

    @GetMapping
    List<Character> findAll() {
        return service.findAll();
    }

    @PutMapping("{id}")
    Character save(@PathVariable String id, @RequestBody NewCharacter newCharacter) {
        return service.save(id, newCharacter);
    }
}
