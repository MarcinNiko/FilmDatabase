package com.omdb.webapp.dao;

import com.omdb.webapp.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Integer> {
    List<Film> findByTitle(String title);

}
