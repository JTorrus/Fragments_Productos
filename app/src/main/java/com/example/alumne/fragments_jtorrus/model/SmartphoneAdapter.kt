package com.example.alumne.fragments_jtorrus.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class SmartphoneAdapter(private var context: Context, private var smartphoneList: ArrayList<Smartphone>, private var itemLayout: Int): BaseAdapter() {
    private var inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val convertVw: View

        if (convertView == null) {
            convertVw = inflater.inflate(itemLayout, null)
        } else {
            convertVw = convertView
        }

        return convertVw
    }

    override fun getItem(position: Int): Any {
        return smartphoneList[position]
    }

    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    override fun getCount(): Int {
        return smartphoneList.size
    }
}