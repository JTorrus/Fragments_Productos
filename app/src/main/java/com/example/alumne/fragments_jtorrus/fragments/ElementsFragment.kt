package com.example.alumne.fragments_jtorrus.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alumne.fragments_jtorrus.R
import com.example.alumne.fragments_jtorrus.model.Smartphone
import com.example.alumne.fragments_jtorrus.model.SmartphoneAdapter
import kotlinx.android.synthetic.main.fragment_product.*

class ElementsFragment : Fragment() {
    private var smartphoneList: ArrayList<Smartphone> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_product, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getData()
        smartphoneListView.adapter = SmartphoneAdapter(this.activity, smartphoneList, R.layout.list_item)
    }

    override fun onStart() {
        super.onStart()
    }

    private fun getData() {
        val smartphoneStocks = resources.getIntArray(R.array.stocks_of_items)
        val smartphoneLabels = resources.getStringArray(R.array.names_of_items)

        for (key in 0 until smartphoneLabels.size) {
            val element = Smartphone(smartphoneLabels[key], smartphoneStocks[key], resources.getIdentifier("smartphone", "drawable", this.activity.packageName))
            smartphoneList.add(element)
        }
    }
}