import axios from "axios";
const MOVIE_BASE_REST_API_URL = "http://localhost:8080/movies";
const MOVIE_BASE_REST_API_URL_S = "http://localhost:8080/movies/search";

class MovieService {
  defaultDetails() {
    let username = "user";
    let password = "123";

    let basicAuthHeader = "Basic " + window.btoa(username + ":" + password);

    return axios.get(MOVIE_BASE_REST_API_URL, {
      headers: {
        authorization: basicAuthHeader,
      },
    });
  }

  getAllMovies(title, year, genre) {
    let username = "user";
    let password = "123";
    let basicAuthHeader = "Basic " + window.btoa(username + ":" + password);
    return axios.get(
      `${MOVIE_BASE_REST_API_URL_S}?title=${title}&year=${year}&genre=${genre}`,
      {
        headers: {
          authorization: basicAuthHeader,
        },
      }
    );
  }
}

export default new MovieService();
