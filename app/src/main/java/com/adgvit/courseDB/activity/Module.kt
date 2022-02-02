package com.adgvit.courseDB.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgvit.courseDB.R
import com.adgvit.courseDB.rvAdapters.ModuleRVAdapter
import java.util.ArrayList

class Module : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var ModuleAdapter: RecyclerView.Adapter<ModuleRVAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module)

        val titles: ArrayList<String> = intent.getStringArrayListExtra("modData") as ArrayList<String>
        val modNo: Int = intent.getIntExtra("modNo",0)
        /*titles.add("Mod 1")
        titles.add("Mod 1")
        titles.add("Mod 1")*/

        val ModuleRV = findViewById<RecyclerView>(R.id.MRV)
        val MName = findViewById<TextView>(R.id.ModuleName)
        val MNo = findViewById<TextView>(R.id.ModuleNo)

        MName.text = titles[0]
        MNo.text = "Module $modNo"

        layoutManager = LinearLayoutManager(this)
        ModuleRV.layoutManager = layoutManager

        ModuleAdapter = ModuleRVAdapter(titles)
        ModuleRV.adapter = ModuleAdapter

    }


}
