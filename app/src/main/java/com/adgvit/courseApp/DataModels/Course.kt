package com.adgvit.courseApp.DataModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "CourseTable"
)
class Course (
    @PrimaryKey
    val courseCode : String ="",
    val courseName : String ="",
    val favourite : Boolean = false
)