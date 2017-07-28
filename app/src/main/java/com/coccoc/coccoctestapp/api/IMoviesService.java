package com.coccoc.coccoctestapp.api;

import com.coccoc.coccoctestapp.models.MovieDetailsResponse;
import com.coccoc.coccoctestapp.models.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by manht on 7/27/2017.
 */

public interface IMoviesService {
    @GET("listSneakShow?cat=2")
    Call<MoviesResponse> getMovies();

    @GET("movie/id/{id}")
    Call<MovieDetailsResponse> getMovieDetails(@Path("id") String id);
}
