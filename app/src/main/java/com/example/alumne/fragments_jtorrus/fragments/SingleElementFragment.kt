package com.example.alumne.fragments_jtorrus.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alumne.fragments_jtorrus.R
import com.example.alumne.fragments_jtorrus.interfaces.OnPhoneSelectedListener
import com.example.alumne.fragments_jtorrus.model.Smartphone
import kotlinx.android.synthetic.main.frag_single_element.*

class SingleElementFragment : Fragment() {
    private lateinit var mCallback: OnPhoneSelectedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mCallback = context as OnPhoneSelectedListener
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.frag_single_element, container, false)
    }

    override fun onStart() {
        super.onStart()
        val data = arguments.getParcelable<Smartphone>("data_smartphone")

        single_image_of_item.setImageResource(data.img)
        single_name_of_item.text = data.name
        single_stock_of_item.text = data.stock.toString()
        single_desc_of_item.text = data.desc
    }

    companion object {
        fun newInstance(smartphone: Smartphone): SingleElementFragment {
            val singleElementFragment = SingleElementFragment()
            val args = Bundle()

            args.putParcelable("data_smartphone", smartphone)
            singleElementFragment.arguments = args

            return singleElementFragment
        }
    }
}