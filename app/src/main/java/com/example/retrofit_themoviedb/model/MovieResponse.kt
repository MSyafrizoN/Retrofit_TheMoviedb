package com.themoviedb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieResponse (
    @SerializedName("result")
    val movies : List<Movie>
) : Parcelable {
    constructor(): this(mutableListOf())
}