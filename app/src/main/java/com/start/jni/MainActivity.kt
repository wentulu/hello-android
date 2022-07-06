package com.start.jni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.start.custom.activity.SlideActivity
import com.start.jni.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()

        binding.sampleText.text = JniTest().add(1,3).toString()

        binding.slideActivity.setOnClickListener {
            startActivity(Intent().also { it.setClass(this@MainActivity, SlideActivity::class.java) })
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}