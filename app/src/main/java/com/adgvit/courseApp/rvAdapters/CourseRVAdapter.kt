package com.adgvit.courseApp.rvAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.Models.Docs
import com.adgvit.courseApp.R

class CourseRVAdapter(
    val listener: ICourseRVAdapter
) : RecyclerView.Adapter<ViewHolderCourses>() {
    var courseList= ArrayList<Docs>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCourses {
        val holder = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_items, parent, false)

        return ViewHolderCourses(holder)
    }


    override fun onBindViewHolder(holder: ViewHolderCourses, position: Int) {
//        with(holder) {
            with(courseList[position]) {
                holder.courseCode.text = this.code
                holder.courseName.text = this.name
                if(this.favourite){
                    holder.imageStar.setImageResource(R.drawable.ic_star_selected)
                }
                else{
                    holder.imageStar.setImageResource(R.drawable.ic_star_notselected)
                }
                holder.imageStar.setOnClickListener{
                    val position: Int = holder.adapterPosition;
                    val currcourse = courseList[position]
                    currcourse.apply {
                        favourite = !favourite
                    }
                    listener.onStarClicked(currcourse)
                }
                holder.itemView.setOnClickListener {
                    val position: Int = holder.adapterPosition;
                    val currcourse = courseList[position]
                    listener.onItemClicked(currcourse)
                }
            }

//        }
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
    fun updateRV(allCourse: List<Docs>){
        courseList.clear()
        courseList.addAll(allCourse)
        notifyDataSetChanged()
    }
}

class ViewHolderCourses(itemView: View) : RecyclerView.ViewHolder(itemView){
    val imageStar: ImageView
    val courseCode: TextView
    val courseName: TextView
    init {
        imageStar = itemView.findViewById(R.id.image_star)
        courseName = itemView.findViewById(R.id.course_name)
        courseCode = itemView.findViewById(R.id.course_code)
    }
}

interface ICourseRVAdapter{
    fun onStarClicked(course: Docs)

    fun onItemClicked(course: Docs)
}