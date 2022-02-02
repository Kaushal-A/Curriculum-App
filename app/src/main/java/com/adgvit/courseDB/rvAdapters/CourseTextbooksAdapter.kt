package com.adgvit.courseDB.rvAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseDB.R

class CourseTextbooksAdapter() : RecyclerView.Adapter<CourseTextbooksAdapter.ViewHolder>() {
    var textbooksList = ArrayList<String>()

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        val textView: TextView = itemView.findViewById(R.id.course_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_textbooks_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(textbooksList[position])
        {
            holder.textView.text = this
        }
    }

    override fun getItemCount(): Int {
        return textbooksList.size
    }

    fun updateRV(allCourse: ArrayList<String>){
        textbooksList.clear()
        textbooksList.addAll(allCourse)
        notifyDataSetChanged()
    }
}
