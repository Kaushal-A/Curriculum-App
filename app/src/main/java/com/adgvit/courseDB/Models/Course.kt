package com.adgvit.courseDB.Models

import com.google.gson.annotations.SerializedName

class Course (
    @SerializedName("credits"    ) var credits   : Credits?          = Credits(),
    @SerializedName("all_topics" ) var allTopics : AllTopics?        = AllTopics(),
    @SerializedName("_id"        ) var Id        : String?           = null,
    @SerializedName("name"       ) var name      : String?           = null,
    @SerializedName("code"       ) var code      : String?           = null,
    @SerializedName("textbooks"  ) var textbooks : ArrayList<String>?           = null,
    @SerializedName("refer_book" ) var referBook : ArrayList<String> = arrayListOf(),
    @SerializedName("__v"        ) var _v        : Int?              = null,
    var favourite: Boolean = false
  ) {

    data class AllTopics (

        @SerializedName("mod1" ) var mod1 : ArrayList<String> = arrayListOf(),
        @SerializedName("mod2" ) var mod2 : ArrayList<String> = arrayListOf(),
        @SerializedName("mod3" ) var mod3 : ArrayList<String> = arrayListOf(),
        @SerializedName("mod4" ) var mod4 : ArrayList<String> = arrayListOf(),
        @SerializedName("mod5" ) var mod5 : ArrayList<String> = arrayListOf(),
        @SerializedName("mod6" ) var mod6 : ArrayList<String> = arrayListOf(),
        @SerializedName("mod7" ) var mod7 : ArrayList<String> = arrayListOf()

    ) {}

    data class Credits (

        @SerializedName("L" ) var L : String? = null,
        @SerializedName("T" ) var T : String? = null,
        @SerializedName("P" ) var P : String? = null,
        @SerializedName("J" ) var J : String? = null,
        @SerializedName("C" ) var C : String? = null

    ) {}

}