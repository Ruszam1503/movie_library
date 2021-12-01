package com.example.movie_library.controller;

import com.example.movie_library.model.Movie;
import com.example.movie_library.service.MovieGenre;
import com.example.movie_library.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final MovieGenre movieGenre;

@Autowired
    public MovieController(MovieService movieService, MovieGenre movieGenre) {
        this.movieService = movieService;
        this.movieGenre = movieGenre;
    }

    @GetMapping("/movie/new")
    public String newMovie(Model model) {
        model.addAttribute("movieForm", new Movie());
        model.addAttribute("method", "new");
        model.addAttribute("genre", movieGenre.findAll());
        return "movie";
    }

    @PostMapping("/movie/new")
    public String newMovie(@ModelAttribute("movieForm") Movie movieForm, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            model.addAttribute("method", "new");
            return "movie";
        }
        movieService.save(movieForm);
        return "redirect:/home";
    }

    @GetMapping("/movie/edit/{id}")
    public String editMovie(@PathVariable("id") Long movieId, Model model) {
        Movie movie = movieService.findById(movieId);
        if (movie != null) {
            model.addAttribute("movieForm", movie);
            model.addAttribute("method", "edit");
            return "movie";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/movie/edit/{id}")
    public String editMovie(@PathVariable("id") Long movieId, @ModelAttribute("productForm") Movie movieForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("method", "edit");
            return "movie";
        }
        movieService.update(movieId, movieForm);

        return "redirect:/home";
    }

    @PostMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long movieId) {
        Movie movie = movieService.findById(movieId);
        if (movie != null) {
            movieService.delete(movieId);
            return "redirect:/home";
        } else {
            return "error/404";
        }
    }
}