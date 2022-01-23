package com.adgvit.courseApp.dataModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "coursetable"
)
class Course (
    @PrimaryKey
    val courseCode : String,
    val courseName : String,
    var favourite : Boolean=false
)