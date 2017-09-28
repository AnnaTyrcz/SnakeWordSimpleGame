package com.github.AnnaTyrcz.SnakeWordSimpleGame.service.Impl;

import com.github.AnnaTyrcz.SnakeWordSimpleGame.model.WordEntry;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.repository.WordEntryRepository;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.service.WordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WordEntryServiceImpl implements WordEntryService{

    @Autowired
    WordEntryRepository wordEntryRepository;

    @Override
    public WordEntry addWord(String word) {
        WordEntry newAddWord = new WordEntry();
        newAddWord.setWord(word);
        newAddWord.setTime(LocalDateTime.now());
        newAddWord = wordEntryRepository.save(newAddWord);

        return newAddWord;

    }


}
