package com.hominoid.expandablerecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
    }

    fun singleViewClick(view: View) {
        startActivity(Intent(this, SingleViewTypeActivity::class.java))
    }

    fun multiViewClick(view: View) {
        startActivity(Intent(this, MultiViewTypeActivity::class.java))
    }

    fun headerMultiViewClick(view: View) {
        startActivity(Intent(this, HeaderMultiViewTypeActivity::class.java))
    }
}