package com.example.alumne.fragments_jtorrus.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alumne.fragments_jtorrus.R
import com.example.alumne.fragments_jtorrus.fragments.ElementsFragment
import com.example.alumne.fragments_jtorrus.fragments.SingleElementFragment
import com.example.alumne.fragments_jtorrus.interfaces.OnPhoneSelectedListener
import com.example.alumne.fragments_jtorrus.model.Smartphone

class MainActivity : AppCompatActivity(), OnPhoneSelectedListener {
    override fun onPhoneSelected(smartphone: Smartphone) {
        val original: SingleElementFragment = supportFragmentManager.findFragmentById(R.id.single_smartphone_fragment) as SingleElementFragment
        val fragmentTransaction: android.support.v4.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        val singleElementFragment = SingleElementFragment.newInstance(smartphone)

        if (original != null) {
            fragmentTransaction.replace(R.id.single_smartphone_fragment, singleElementFragment)
            fragmentTransaction.commit()
        } else {
            fragmentTransaction.replace(R.id.containerPanel, singleElementFragment).addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (findViewById<View>(R.id.containerPanel) != null) {
            val fragmentTransaction: android.support.v4.app.FragmentTransaction = supportFragmentManager.beginTransaction()
            val elementsFragment = ElementsFragment()

            fragmentTransaction.add(R.id.containerPanel, elementsFragment)
            fragmentTransaction.commit()
        }
    }
}
