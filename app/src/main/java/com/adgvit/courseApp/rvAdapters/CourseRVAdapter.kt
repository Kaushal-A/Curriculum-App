package com.adgvit.courseApp.rvAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.R
import com.adgvit.courseApp.dataModels.Course
import com.adgvit.courseApp.databinding.CourseItemsBinding

class CourseRVAdapter(
        val listener: ICourseRVAdapter
) : RecyclerView.Adapter<ViewHolderCourses>() {
    var courseList= ArrayList<Course>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCourses {
        val binding = CourseItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolderCourses(binding)
    }


    override fun onBindViewHolder(holder: ViewHolderCourses, position: Int) {
        with(holder) {
            with(courseList[position]) {
                binding.courseCode.text = this.courseCode
                binding.courseName.text = this.courseName
                if(this.favourite){
                    binding.imageStar.setImageResource(R.drawable.ic_star_selected)
                }
                else{
                    binding.imageStar.setImageResource(R.drawable.ic_star_notselected)
                }
                binding.imageStar.setOnClickListener{
                    val position: Int = holder.adapterPosition;
                    val currcourse = courseList[position]
                   currcourse.apply { favourite = !favourite }
                    listener.onStarClicked(currcourse)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
    fun updateRV(allCourse: List<Course>){
        courseList.clear()
        courseList.addAll(allCourse)
        notifyDataSetChanged()
    }
}

class ViewHolderCourses(val binding: CourseItemsBinding) : RecyclerView.ViewHolder(binding.root)

interface ICourseRVAdapter{
    fun onStarClicked(course: Course)

    fun onItemClicked(course: Course)
}