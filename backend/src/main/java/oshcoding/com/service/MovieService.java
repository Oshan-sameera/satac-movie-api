package oshcoding.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oshcoding.com.entity.Movie;
import oshcoding.com.exception.MovieNotFoundException;
import oshcoding.com.jsonFileReader.MainDataClass;

@Service
public class MovieService {

	@Autowired
	private MainDataClass mainDataClass;

	public List<Movie> getMovieDetails(String movieTitle, String movieYear, String movieGenre) {
		
		List<Movie> movieList = mainDataClass.getAllMovies();
		String inputTitleConvert = movieTitle.trim().toLowerCase();
		String inputGenreConvert = movieGenre.trim().toLowerCase();
		int inputYearConvert = Integer.parseInt(movieYear.trim());

		Predicate<Movie> preTitle = movie -> movie.getTitle().toLowerCase().contains(inputTitleConvert);
		Predicate<Movie> preYear = movie -> movie.getYear() == inputYearConvert;
		Predicate<Movie> preGenre = movie -> movie.getGenreString().contains(inputGenreConvert);

		List<Movie> newMovies = new ArrayList<Movie>();
	
		if (inputTitleConvert != null) {
			newMovies = movieList.stream().filter(preTitle).collect(Collectors.toList());
		} 
		if (inputYearConvert != 0) {

			newMovies = newMovies.stream().filter(preYear).collect(Collectors.toList());
		}
		if (movieGenre != null) {
			newMovies = newMovies.stream().filter(preGenre).collect(Collectors.toList());
		}
		
		
		
		return newMovies;
	}

	public List<Movie> getAllMovie() {

		List<Movie> movieList = mainDataClass.getAllMovies();

		List<Movie> newMoviesList = new ArrayList<>();
		for (Movie s : movieList) {
			newMoviesList.add(s);
		}
		if (newMoviesList.size()==0) {
			throw new MovieNotFoundException("No movies found");

		}
	

		return newMoviesList;
	}

}
