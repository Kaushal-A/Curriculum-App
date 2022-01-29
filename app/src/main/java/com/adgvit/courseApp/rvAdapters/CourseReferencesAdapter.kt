package com.adgvit.courseApp.rvAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.R

class CourseReferencesAdapter() : RecyclerView.Adapter<CourseReferencesAdapter.ViewHolder>() {
    var ReferenceList = ArrayList<String>()

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        val textView: TextView = itemView.findViewById(R.id.course_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_modules_item, parent, false)

        return CourseReferencesAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(ReferenceList[position])
//        {
//            holder.textView.text = this.
//        }
    }

    override fun getItemCount(): Int {
        return ReferenceList.size
    }
}