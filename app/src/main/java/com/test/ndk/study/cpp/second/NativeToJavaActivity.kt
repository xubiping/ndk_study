package com.test.ndk.study.cpp.second

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.test.ndk.study.databinding.ActivitySecondNativeToJavaBinding

class NativeToJavaActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondNativeToJavaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondNativeToJavaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Native->Java"
        binding.booleanTest.setOnClickListener {
            Log.v("tag","booleanTest"+NativeUtil().javaBooleanFromNative())

        }
        binding.byteTest.setOnClickListener {
            Log.v("tag","byteTest"+NativeUtil().javaByteFromNative())

        }
        binding.charTest.setOnClickListener {
            Log.v("tag","charTest"+NativeUtil().javaCharFromNative())
        }
        binding.shortTest.setOnClickListener {
            Log.v("tag","shortTest"+NativeUtil().javaShortFromNative())
        }
        binding.intTest.setOnClickListener {
            Log.v("tag","intTest"+NativeUtil().javaIntFromNative())
        }
        binding.longTest.setOnClickListener {
            Log.v("tag","longTest"+NativeUtil().javaLongFromNative())
        }
        binding.floatTest.setOnClickListener {
            Log.v("tag","floatTest"+NativeUtil().javaFloatFromNative())
        }
        binding.doubleTest.setOnClickListener {
            Log.v("tag","doubleTest"+NativeUtil().javaDoubleFromNative())
        }
    }
}