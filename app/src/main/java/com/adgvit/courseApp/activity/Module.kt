package com.adgvit.courseApp.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.adgvit.courseApp.R

class Module : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module)

        val listView = findViewById<ListView>(R.id.ModuleTopics)
        listView.adapter = CustomAdapter(this)
    }

    private class CustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        private val Topics = arrayListOf<String>(
            "1.Input-Output Channels", "2.Human memory", "3.HCI Foundations"
        )

        init {
            mContext = context
        }

        override fun getCount(): Int {
            return Topics.size
        }

        override fun getItem(position: Int): Any {
            return "Sample String!"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong();
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val listViewText = layoutInflater.inflate(R.layout.textview_listview, parent, false)

            val lTV = listViewText.findViewById<TextView>(R.id.ListViewText)
            lTV.text = Topics.get(position)

            return listViewText
            /*val textView = TextView(mContext)
            textView.text = "1.Input-output channels"
            return textView*/
        }
    }
}