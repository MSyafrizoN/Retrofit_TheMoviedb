package com.themoviedb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TVResponse(
    @SerializedName("result")
    val television : List<TV>
) : Parcelable{
    constructor(): this(mutableListOf())
}