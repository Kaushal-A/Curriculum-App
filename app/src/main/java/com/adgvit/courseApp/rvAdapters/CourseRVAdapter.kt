package com.adgvit.courseApp.rvAdapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.R
import com.adgvit.courseApp.dataModels.Course
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
                if(this.favourite){
                    binding.imageStar.setImageResource(R.drawable.ic_star_selected)
                }
                else{
                    binding.imageStar.setImageResource(R.drawable.ic_star_notselected)
                }
                binding.imageStar.setOnClickListener(View.OnClickListener { view ->
                    var position: Int = holder.adapterPosition;
                    courseList[position].apply { favourite = !favourite }
                    notifyDataSetChanged()
                })
            }
        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}

class ViewHolderCourses(val binding: CourseItemsBinding) : RecyclerView.ViewHolder(binding.root)