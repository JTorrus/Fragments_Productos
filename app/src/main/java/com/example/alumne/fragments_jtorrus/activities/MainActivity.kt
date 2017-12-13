package com.example.alumne.fragments_jtorrus.activities

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.alumne.fragments_jtorrus.R
import com.example.alumne.fragments_jtorrus.fragments.ProductFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = this.fragmentManager
        val fragmentTrans: FragmentTransaction = fragmentManager.beginTransaction()

        fragmentTrans.replace(R.id.containerPanel, ProductFragment())
        fragmentTrans.commit()
    }
}
