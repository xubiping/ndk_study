package com.test.ndk.study.cpp.second

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.test.ndk.study.databinding.ActivitySecondJavaToNativeBinding

class JavaToNativeActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondJavaToNativeBinding
  //  val  TAG:String = localClassName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondJavaToNativeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Java -> Native"
        binding.booleanTest.setOnClickListener {
           Log.v("tag","booleanTest")
            NativeUtil().javaBooleanToNative(true)
        }
      binding.byteTest.setOnClickListener {
          Log.v("tag","byteTest")
          NativeUtil().javaByteToNative(2)
      }
      binding.charTest.setOnClickListener {
          Log.v("tag","charTest")
          NativeUtil().javaCharToNative('c')
      }
      binding.shortTest.setOnClickListener {
          Log.v("tag","shortTest")
          NativeUtil().javaShortToNative(10)
      }
      binding.intTest.setOnClickListener {
          Log.v("tag","intTest")
          NativeUtil().javaInttoNative(100)
      }
      binding.longTest.setOnClickListener {
          Log.v("tag","longTest")
          NativeUtil().javaLongToNative(1000)
      }
      binding.floatTest.setOnClickListener {
          Log.v("tag","floatTest")
          NativeUtil().javaFloatToNative(10000f)
      }
      binding.doubleTest.setOnClickListener {
          Log.v("tag","doubleTest")
          NativeUtil().javaDoubleToNative(100000.000)
      }

    }
}