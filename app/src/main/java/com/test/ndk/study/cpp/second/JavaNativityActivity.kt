package com.test.ndk.study.cpp.second

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.test.ndk.study.databinding.ActivitySecondJavaNativeBinding

class JavaNativityActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondJavaNativeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondJavaNativeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Java<->Native"
        binding.charconcattest.setOnClickListener {
            var str = NativeUtil().charConcatTest('A','X','C')
            binding.charConcatText.text = "A+B+C="+str
        }
        binding.sumTest.setOnClickListener {
            var numOne = 123;
            var numTwo = 456;
            var value=NativeUtil().sumText(numOne,numTwo)
            binding.sumTest.text = ""+numOne + "+" + numTwo + "=" + value
        }
        binding.twoexptest.setOnClickListener {
            binding.twoExpText.text = "2^10="+NativeUtil().twoExpTest(10)
        }
        binding.calcMoneyTest.setOnClickListener {
            var apple = 12.4
            var banana = 99.8
            var orange = 101.1
            var value =  NativeUtil().calcMoneyText(apple,banana,orange)
            binding.calcMoneyText.text = value
        }
    }
}