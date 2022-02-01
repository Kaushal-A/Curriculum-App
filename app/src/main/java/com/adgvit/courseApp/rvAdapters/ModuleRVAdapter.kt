package com.adgvit.courseApp.rvAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.R

class ModuleRVAdapter(private val titles : ArrayList<String>): RecyclerView.Adapter<ModuleRVAdapter.ViewHolder>() {
    /*private var titles = arrayOf(
        "1.Input-Output Channels", "2.Human memory", "3.HCI Foundations"
    )*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleRVAdapter.ViewHolder {
        val V = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_module_text, parent, false)
        return ViewHolder(V)
    }

    override fun onBindViewHolder(holder: ModuleRVAdapter.ViewHolder, position: Int) {
        val currentItem = titles[position]
        holder.itemText.text = "${position+1}  "+currentItem
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemText: TextView = itemView.findViewById(R.id.RVTextView)

    }

}