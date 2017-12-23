package com.example.alumne.fragments_jtorrus.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alumne.fragments_jtorrus.R
import com.example.alumne.fragments_jtorrus.fragments.ElementsFragment
import com.example.alumne.fragments_jtorrus.fragments.SingleElementFragment
import com.example.alumne.fragments_jtorrus.interfaces.OnPhoneSelectedListener
import com.example.alumne.fragments_jtorrus.model.Smartphone

class MainActivity : AppCompatActivity(), OnPhoneSelectedListener {
    override fun onPhoneSelected(smartphone: Smartphone) {
        val fragmentTransaction: android.support.v4.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        val singleElementFragment = SingleElementFragment.newInstance(smartphone)

        fragmentTransaction.replace(R.id.containerPanel, singleElementFragment).addToBackStack("stack")
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTransaction: android.support.v4.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        val elementsFragment = ElementsFragment()

        fragmentTransaction.add(R.id.containerPanel, elementsFragment)
        fragmentTransaction.commit()
    }
}
