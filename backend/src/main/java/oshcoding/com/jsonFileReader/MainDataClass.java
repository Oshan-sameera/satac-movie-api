package oshcoding.com.jsonFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;
import oshcoding.com.controller.MovieController;
import oshcoding.com.entity.Movie;
import oshcoding.com.exception.MovieNotFoundException;

@Component
@Log4j2
public class MainDataClass {

	@Value("${spring.datasource.url}")
	private String datasource;

	public List<Movie> getAllMovies() {

		List<Movie> movies = null;

		try {
			TypeReference<List<Movie>> typerefrence = new TypeReference<List<Movie>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream(datasource);
			movies = new ObjectMapper().readValue(inputStream, typerefrence);
			return movies;
		} catch (IOException ex) {	
			
			log.error(ex );

		}
		return movies;
	}
}
