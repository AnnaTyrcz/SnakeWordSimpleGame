package com.github.AnnaTyrcz.SnakeWordSimpleGame.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WordEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime time;
    private String word;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setUser(User loggedUser) {
    }
}
