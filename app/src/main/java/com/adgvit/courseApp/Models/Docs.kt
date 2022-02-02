package com.adgvit.courseApp.Models

import com.google.gson.annotations.SerializedName

class Docs (

    @SerializedName("name" ) var name : String,
    @SerializedName("code" ) var code : String,
    var favourite: Boolean = false
) {

}