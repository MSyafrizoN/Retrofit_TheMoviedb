package com.example.retrofit_themoviedb.service

import com.themoviedb.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=2c7e6ab9a0ea816b8dd03293fbb7d81d")
    fun getMovieList() : Call<MovieResponse>
}