package oshcoding.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import oshcoding.com.entity.Movie;
import oshcoding.com.service.MovieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/movies")
@Log4j2
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public List<Movie> getAllMovies() {
		log.info("Getting all the movies form the josn file");
		return movieService.getAllMovie();
	}

	@GetMapping("/search")
	public List<Movie> getMovies(@RequestParam(name = "title", required = false, defaultValue = "") String movieTitle,
			@RequestParam(name = "year", required = false, defaultValue = "0") String movieYear,
			@RequestParam(name = "genre", required = false, defaultValue = "") String movieGenre) {

		log.info("searching  movie details by given inputs");
		return movieService.getMovieDetails(movieTitle, movieYear, movieGenre);

	}

}
