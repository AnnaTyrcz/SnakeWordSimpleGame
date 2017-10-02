package com.github.AnnaTyrcz.SnakeWordSimpleGame.repository;

import com.github.AnnaTyrcz.SnakeWordSimpleGame.model.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordEntryRepository extends JpaRepository<WordEntry, Long>{

    WordEntry findFirstByOrderByTimeDesc();
    WordEntry findTop10ByOrderByTimeDesc();




}
