package com.adgvit.courseApp.rvAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.DataModels.Course
import com.adgvit.courseApp.databinding.CourseItemsBinding

class CourseRVAdapter(
    var courseList: List<Course>,
) : RecyclerView.Adapter<ViewHolderCourses>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCourses {
        val binding = CourseItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolderCourses(binding)
    }


    override fun onBindViewHolder(holder: ViewHolderCourses, position: Int) {
        with(holder) {
            with(courseList[position]) {
                binding.courseCode.text = this.courseCode
                binding.courseName.text = this.courseName
            }
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}

class ViewHolderCourses(val binding: CourseItemsBinding) : RecyclerView.ViewHolder(binding.root) {

}