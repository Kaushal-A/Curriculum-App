package com.adgvit.courseDB.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseDB.R
import com.adgvit.courseDB.activity.CourseActivity
import com.adgvit.courseDB.rvAdapters.CourseModulesAdapter

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

    override fun onDestroy() {
        super.onDestroy()
        moduleAdapter.deleteRV()
    }

}