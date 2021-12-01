package com.example.movie_library.controller;

import com.example.movie_library.model.Movie;
import com.example.movie_library.service.MovieCartService;
import com.example.movie_library.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    private final MovieCartService movieCartService;
    private final MovieService movieService;

    public CartController(MovieCartService movieCartService, MovieService movieService) {
        this.movieCartService = movieCartService;
        this.movieService = movieService;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("movies", movieCartService.getMovieInCart());
        model.addAttribute("countMovies", movieCartService.countMovies());
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addMovieCart(@PathVariable("id") long id) {
        Movie movie = movieService.findById(id);
        if (movie != null) {
            movieCartService.addMovie(movie);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeMovieCart(@PathVariable("id") long id) {
        Movie movie = movieService.findById(id);
        if (movie != null) {
            movieCartService.removeMovie(movie);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearMovieInCart(){
        movieCartService.clearMovie();

        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(){
        movieCartService.clearMovie();

        return "redirect:/cart";
    }

}
