package com.github.AnnaTyrcz.SnakeWordSimpleGame.controller;

import com.github.AnnaTyrcz.SnakeWordSimpleGame.service.WordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/snake")
public class GameController {

    @Autowired
    WordEntryService wordEntryService;
}
