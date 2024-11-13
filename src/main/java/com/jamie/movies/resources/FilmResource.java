package com.jamie.movies.resources;

import com.jamie.movies.models.Film;
import com.jamie.movies.repo.FilmRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/films")
public class FilmResource {

    @Inject
    FilmRepository filmRepository;

    @GET
    @Path("/hello-world")
    @Produces(value = MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello World";
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Film getFilm(@PathParam(value = "id")short id){
        return filmRepository.getFilm(id).orElseThrow();
    }
}
