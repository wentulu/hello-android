package com.start.custom.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.start.custom.view.R
import com.start.custom.view.slide.ScrollerLayout

class SlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)
        findViewById<ScrollerLayout>(R.id.scroller_layout).setOnClickListener {
            (it as ScrollerLayout).smoothScrollTo(-400, 0)
        }
    }
}