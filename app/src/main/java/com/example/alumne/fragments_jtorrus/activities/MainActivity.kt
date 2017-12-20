package com.example.alumne.fragments_jtorrus.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alumne.fragments_jtorrus.R
import com.example.alumne.fragments_jtorrus.fragments.ElementsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: android.support.v4.app.FragmentManager = supportFragmentManager
        val fragmentTrans: android.support.v4.app.FragmentTransaction = fragmentManager.beginTransaction()

        val elementsFragment = ElementsFragment()
        fragmentTrans.add(R.id.containerPanel, elementsFragment)

        fragmentTrans.commit()
    }
}
