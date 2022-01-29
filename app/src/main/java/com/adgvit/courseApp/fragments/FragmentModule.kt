package com.adgvit.courseApp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseApp.R
import com.adgvit.courseApp.rvAdapters.ModuleRVAdapter

class FragmentModule : Fragment() {
    lateinit var recviewModule: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_module, container, false)
        recviewModule = view.findViewById(R.id.rec_view_module)
        recviewModule.layoutManager = LinearLayoutManager(context)
        recviewModule.adapter = ModuleRVAdapter()
        return view
    }

    fun setAdapter()
    {
        recviewModule.adapter = ModuleRVAdapter()
    }

}