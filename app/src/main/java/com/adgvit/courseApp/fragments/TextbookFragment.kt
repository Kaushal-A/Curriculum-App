package com.adgvit.courseApp.fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.R
import com.adgvit.courseApp.activity.CourseActivity
import com.adgvit.courseApp.rvAdapters.CourseTextbooksAdapter
import com.adgvit.courseApp.rvAdapters.ModuleRVAdapter
import com.adgvit.courseApp.viewModel.CourseViewModel

//FROM THE BACKEND WE RECEIVE A STRING OF TEXTBOOKS, HOW DO I DISPLAY IT IN THE RECYCLER VIEW

class TextbookFragment : Fragment() {
    lateinit var recViewTextbook : RecyclerView
    lateinit var textbookAdapter: CourseTextbooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        textbookAdapter = CourseTextbooksAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_textbook, container, false)
        recViewTextbook = view.findViewById(R.id.rec_view_textbooks)
        recViewTextbook.layoutManager = LinearLayoutManager(context)
        recViewTextbook.adapter = textbookAdapter

        CourseActivity.DataList.observe(viewLifecycleOwner, Observer {
            it.textbooks?.let {

                it.remove("")
                textbookAdapter.updateRV(it)
            }
        })

        return view
    }
}