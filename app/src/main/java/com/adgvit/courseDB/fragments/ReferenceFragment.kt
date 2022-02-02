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
import com.adgvit.courseDB.rvAdapters.CourseReferencesAdapter

class ReferenceFragment : Fragment() {
    lateinit var recViewReferences: RecyclerView
    lateinit var referenceAdapter: CourseReferencesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        referenceAdapter = CourseReferencesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_reference, container, false)
        recViewReferences = view.findViewById(R.id.rec_view_references)
        recViewReferences.layoutManager = LinearLayoutManager(context)
        recViewReferences.adapter = referenceAdapter

        CourseActivity.DataList.observe(viewLifecycleOwner, Observer {
            it.referBook?.let { it1 -> referenceAdapter.updateRV(it1) }
        })

        return view
    }

}