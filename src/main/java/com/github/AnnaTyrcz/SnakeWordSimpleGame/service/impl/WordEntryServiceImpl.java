package com.github.AnnaTyrcz.SnakeWordSimpleGame.service.impl;

import com.github.AnnaTyrcz.SnakeWordSimpleGame.exceptions.FirstLetterNotMatchException;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.exceptions.ForbiddenWordException;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.model.User;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.model.WordEntry;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.repository.UserRepository;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.repository.WordEntryRepository;
import com.github.AnnaTyrcz.SnakeWordSimpleGame.service.WordEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class WordEntryServiceImpl implements WordEntryService {

    @Autowired
    WordEntryRepository wordEntryRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addWord(String word) {

        checkWordInSnake(word);

        WordEntry lastWord = (WordEntry) wordEntryRepository.findAllByOrderByTimeDesc();
        WordEntry wordEntry = new WordEntry();
        User loggedUser = userRepository.findOne(getLoggedUserId());
        wordEntry.setUser(loggedUser);
        if (lastWord == null) {
            wordEntry.setWord(formatWord(word));
            wordEntry.setTime(LocalDateTime.now());
            wordEntryRepository.save(wordEntry);
        } else {
            String nextWord = formatWord(word);
            wordEntry.setWord(nextWord);
            wordEntry.setTime(LocalDateTime.now());
            wordEntryRepository.save(wordEntry);

            lastWord.setWord(word);
            lastWord.setTime(LocalDateTime.now());
            lastWord = wordEntryRepository.save(lastWord);

            return;

        }
    }



    private String formatWord(String word) {
        int length = word.length();
        return word.substring(0, 1).toUpperCase()
                + word.substring(1, length - 1)
                + word.substring(length - 1, length).toUpperCase();
    }

    private void checkWordInSnake(String word) {
        WordEntry lastWord = wordEntryRepository.findFirstByOrderByTimeDesc();
        if (lastWord == null) {
            return;
        }

        String oldWord = lastWord.getWord();
        if (word.isEmpty()) {
            throw new FirstLetterNotMatchException();
        }
        String firstLetterOfNewWord = word.substring(0, 1);

        if (StringUtils.endsWithIgnoreCase(oldWord, firstLetterOfNewWord)) {
            return;
        }
        throw new FirstLetterNotMatchException();
    }

    private void validate(String word) {
        if (word.toLowerCase().endsWith("y")) {
            throw new ForbiddenWordException();
        }
    }

    private Long getLoggedUserId() {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User)) {
            throw new RuntimeException();
        }
        User user = (User) principal;
        return user.getId();
    }

    @Override
    public List<String> findAll() {
        return wordEntryRepository.findAllByUserIdOrderByTimeDesc(getLoggedUserId())
                .stream()
                .sorted(comparing(WordEntry::getTime))
                .map(WordEntry::getWord)
                .collect(toList());
    }


}
