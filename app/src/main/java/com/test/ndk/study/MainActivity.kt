package com.test.ndk.study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.test.ndk.study.cpp.second.JavaNativityActivity
import com.test.ndk.study.cpp.second.JavaToNativeActivity
import com.test.ndk.study.cpp.second.NativeToJavaActivity
import com.test.ndk.study.cpp.useDataType.UserDataTypeActivity
import com.test.ndk.study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
        binding.jtonative.setOnClickListener {
            startActivity(Intent(this,JavaToNativeActivity().javaClass))
        }
        binding.nativetoj.setOnClickListener {
            startActivity(Intent(this,NativeToJavaActivity().javaClass))
        }
        binding.javanative.setOnClickListener {
            startActivity(Intent(this,JavaNativityActivity().javaClass))
        }

        binding.datatype.setOnClickListener {
            startActivity(Intent(this,UserDataTypeActivity().javaClass))
        }
    }


    /**
     * A native method that is implemented by the 'study' native library,
     * which is packaged with this application.
     *
     * external fun kotlin 声明方式
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'study' library on application startup.
        init {
            System.loadLibrary("study")
        }
    }

}