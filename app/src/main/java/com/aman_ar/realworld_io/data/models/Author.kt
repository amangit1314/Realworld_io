package com.aman_ar.realworld_io.data.models

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("bio")
    var bio: String,
    @SerializedName("following")
    var following: Boolean,
    @SerializedName("image")
    var image: String,
    @SerializedName("username")
    var username: String
)
