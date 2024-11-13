package com.jamie.movies.repo;

import com.jamie.movies.models.Film;
import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FilmRepository {
    @Inject
    JPAStreamer jpaStreamer;

    public Optional<Film> getFilm(short fieldId){
        return jpaStreamer.stream(Film.class)
                .filter(film -> film.getId() == fieldId)
                .findFirst();
    }
}
