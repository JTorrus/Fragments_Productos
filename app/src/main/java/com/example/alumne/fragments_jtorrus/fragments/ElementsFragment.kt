package com.example.alumne.fragments_jtorrus.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.alumne.fragments_jtorrus.R
import com.example.alumne.fragments_jtorrus.interfaces.OnPhoneSelectedListener
import com.example.alumne.fragments_jtorrus.model.Smartphone
import com.example.alumne.fragments_jtorrus.model.SmartphoneAdapter
import kotlinx.android.synthetic.main.frag_elements.*

class ElementsFragment : Fragment(), AdapterView.OnItemClickListener {
    private var smartphoneList: ArrayList<Smartphone> = ArrayList()
    private lateinit var mCallback: OnPhoneSelectedListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.frag_elements, container, false)
    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        mCallback.onPhoneSelected(smartphoneList[position])
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getData()
        smartphoneListView.adapter = SmartphoneAdapter(this.activity, smartphoneList, R.layout.list_elements)
        smartphoneListView.onItemClickListener = this
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mCallback = context as OnPhoneSelectedListener
    }

    override fun onStart() {
        super.onStart()
    }

    private fun getData() {
        val smartphoneStocks = resources.getIntArray(R.array.stocks_of_items)
        val smartphoneLabels = resources.getStringArray(R.array.names_of_items)
        val smartphoneDescs = resources.getStringArray(R.array.desc_of_items)

        for (key in 0 until smartphoneLabels.size) {
            val element = Smartphone(smartphoneLabels[key], smartphoneStocks[key], resources.getIdentifier("smartphone", "drawable", this.activity.packageName), smartphoneDescs[key])
            smartphoneList.add(element)
        }
    }
}