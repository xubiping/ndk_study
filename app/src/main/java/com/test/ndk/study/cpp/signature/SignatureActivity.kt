package com.test.ndk.study.cpp.signature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.ndk.study.cpp.hash.NativeHashUtil
import com.test.ndk.study.databinding.ActivitySignatureBinding

class SignatureActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignatureBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignatureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.javaGetSignature.setOnClickListener {
            binding.javaSignatureText.text =  SignatureUtil.getSignatureStr(applicationContext);
        }
        binding.nativeGetSignature.setOnClickListener {
            binding.nativeSignatureText.text = NativeSignatureUtil.getSignature(applicationContext);
        }
        binding.checkSignature.setOnClickListener {
            binding.checkSignatureText.text = NativeSignatureUtil.checkSignature(applicationContext);
        }
    }
}