package com.github.AnnaTyrcz.SnakeWordSimpleGame.service;

import java.util.List;

public interface WordEntryService {

    void addWord(String word);


    List<String> findAll();
}

