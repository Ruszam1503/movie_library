package com.example.movie_library.controller;

import com.example.movie_library.service.MovieGenre;
import com.example.movie_library.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private final MovieService movieService;
    private final MovieGenre movieGenre;


    @Autowired
    public HomeController(MovieService movieService, MovieGenre movieGenre) {
        this.movieService = movieService;
        this.movieGenre = movieGenre;
    }

    @GetMapping(value = {"/","/index","/home"})
    public String home (Model model){
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("moviesCount", movieService.getMoviesCount());
        model.addAttribute("genres", movieGenre.findAll());
        return "home";
    }


}
