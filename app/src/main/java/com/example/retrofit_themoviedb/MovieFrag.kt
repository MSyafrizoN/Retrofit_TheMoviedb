package com.example.retrofit_themoviedb
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_themoviedb.service.MovieApiInterface
import com.example.retrofit_themoviedb.service.MovieApiService
import com.themoviedb.adaptors.MovieAdaptor
import com.themoviedb.model.Movie
import com.themoviedb.model.MovieResponse
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFrag : Fragment() {
    private val movies = arrayListOf<Movie>()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_movie, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movies.layoutManager = LinearLayoutManager(this.context)
        rv_movies.setHasFixedSize(true)
        getMovieData{movies: List<Movie> ->
            rv_movies.adapter = MovieAdaptor(movies)
        }
        showRecycleView()
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object: Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t:Throwable){
            }
            override fun onResponse(call: Call<MovieResponse>,response:Response<MovieResponse>){
                return callback(response.body()!!.movies)
            }
        })
    }

    private fun showRecycleView(){
        rv_movies.layoutManager = LinearLayoutManager(this.context)
        rv_movies.adapter = MovieAdaptor(movies)
    }
}