package com.adgvit.courseApp.rvAdapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.Models.Course
import com.adgvit.courseApp.R
import com.adgvit.courseApp.activity.Module
import kotlinx.coroutines.NonDisposableHandle.parent

class CourseModulesAdapter() : RecyclerView.Adapter<CourseModulesAdapter.ViewHolder>() {
    var courseAllTopics: Course.AllTopics = Course.AllTopics()
    var modList: ArrayList<String> = ArrayList()
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_modules_item, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.course_name)
        val card: CardView = itemView.findViewById(R.id.module_card)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            when (position) {
                0 -> {
                    holder.textView.text = "${position+1}  "+courseAllTopics.mod1[0]
                }
                1 -> {
                    holder.textView.text = "${position+1}  "+courseAllTopics.mod2[0]
                }
                2 -> {
                    holder.textView.text = "${position+1}  "+courseAllTopics.mod3[0]
                }
                3 -> {
                    holder.textView.text = "${position+1}  "+courseAllTopics.mod4[0]
                }
                4 -> {
                    holder.textView.text = "${position+1}  "+courseAllTopics.mod5[0]
                }
                5 -> {
                    holder.textView.text = "${position+1}  "+courseAllTopics.mod6[0]
                }
                6 -> {
                    holder.textView.text = "${position+1}  "+courseAllTopics.mod7[0]
                }
            }

            holder.card.setOnClickListener(View.OnClickListener {
                val intent: Intent = Intent(holder.textView.context,Module::class.java)

                when (position) {
                    0 -> {
                        intent.putStringArrayListExtra("modData",courseAllTopics.mod1)
                        intent.putExtra("modNo",position+1)
                    }
                    1 -> {
                        intent.putStringArrayListExtra("modData",courseAllTopics.mod2)
                        intent.putExtra("modNo",position+1)
                    }
                    2 -> {
                        intent.putStringArrayListExtra("modData",courseAllTopics.mod3)
                        intent.putExtra("modNo",position+1)
                    }
                    3 -> {
                        intent.putStringArrayListExtra("modData",courseAllTopics.mod4)
                        intent.putExtra("modNo",position+1)
                    }
                    4 -> {
                        intent.putStringArrayListExtra("modData",courseAllTopics.mod5)
                        intent.putExtra("modNo",position+1)
                    }
                    5 -> {
                        intent.putStringArrayListExtra("modData",courseAllTopics.mod6)
                        intent.putExtra("modNo",position+1)
                    }
                    6 -> {
                        intent.putStringArrayListExtra("modData",courseAllTopics.mod7)
                        intent.putExtra("modNo",position+1)
                    }
                }

                holder.textView.context.startActivity(intent)
            })

        }catch (e: Exception) {
            Toast.makeText(holder.textView.context,e.localizedMessage,Toast.LENGTH_LONG ).show()
//            System.out.println("ERROR : " + e.localizedMessage)
        }
    }

    override fun getItemCount(): Int {
        return 7
    }

    fun updateRV(allCourse: Course.AllTopics){
        courseAllTopics = allCourse
//        courseModuleList.addAll(allCourse)
        notifyDataSetChanged()
    }
}