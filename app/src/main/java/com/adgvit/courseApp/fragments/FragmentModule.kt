package com.adgvit.courseApp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.R
import com.adgvit.courseApp.activity.CourseActivity
import com.adgvit.courseApp.rvAdapters.CourseModulesAdapter
import com.adgvit.courseApp.rvAdapters.CourseTextbooksAdapter
import com.adgvit.courseApp.rvAdapters.ModuleRVAdapter

class FragmentModule : Fragment() {
    lateinit var recviewModule: RecyclerView
    lateinit var moduleAdapter: CourseModulesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moduleAdapter = CourseModulesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_module, container, false)
        recviewModule = view.findViewById(R.id.rec_view_module)
        recviewModule.layoutManager = LinearLayoutManager(context)
        recviewModule.adapter = moduleAdapter

        CourseActivity.DataList.observe(viewLifecycleOwner, Observer {
            it.allTopics?.let { it1 -> moduleAdapter.updateRV(it1) }
        })

        return view
    }

}