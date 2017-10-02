package com.github.AnnaTyrcz.snakeWordSimpleGame.controller;

import com.github.AnnaTyrcz.snakeWordSimpleGame.service.WordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snake")
public class GameController {

    @Autowired
    WordEntryService wordEntryService;

    @PutMapping("/{word}")
    public void addWord(@PathVariable String word) {
        wordEntryService.addWord(word);
    }

    @GetMapping
    public List<String> getSnake() {
        return wordEntryService.findAll();
    }

    @GetMapping("/info")
    public String info() {
        return "everything ok.";
    }
}
