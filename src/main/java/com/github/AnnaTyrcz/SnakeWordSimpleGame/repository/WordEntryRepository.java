package com.github.AnnaTyrcz.SnakeWordSimpleGame.repository;

import com.github.AnnaTyrcz.SnakeWordSimpleGame.model.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordEntryRepository extends JpaRepository<WordEntry, Long>{

    WordEntry findFirstByOrderByTimeDesc();
    List<WordEntry> findAllByUserIdOrderByTimeDesc(Long loggedUserId);
    List<WordEntry> findAllByOrderByTimeDesc();




}
