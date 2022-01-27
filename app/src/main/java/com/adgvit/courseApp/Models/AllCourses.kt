package com.adgvit.courseApp.Models

import com.google.gson.annotations.SerializedName

class AllCourses (

    @SerializedName("docs"          ) var docs          : List<Docs>,
    @SerializedName("totalDocs"     ) var totalDocs     : Int,
    @SerializedName("limit"         ) var limit         : Int,
    @SerializedName("totalPages"    ) var totalPages    : Int,
    @SerializedName("page"          ) var page          : Int,
    @SerializedName("pagingCounter" ) var pagingCounter : Int,
    @SerializedName("hasPrevPage"   ) var hasPrevPage   : Boolean,
    @SerializedName("hasNextPage"   ) var hasNextPage   : Boolean,
    @SerializedName("prevPage"      ) var prevPage      : String,
    @SerializedName("nextPage"      ) var nextPage      : String

) {

}