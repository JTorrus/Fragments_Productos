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

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: android.support.v4.app.FragmentManager = supportFragmentManager
        val fragmentTransaction: android.support.v4.app.FragmentTransaction = fragmentManager.beginTransaction()

        val elementsFragment = ElementsFragment()
        fragmentTransaction.add(R.id.containerPanel, elementsFragment)

        fragmentTransaction.commit()
    }
}
