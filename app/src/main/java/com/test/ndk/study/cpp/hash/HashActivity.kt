package com.test.ndk.study.cpp.hash

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.test.ndk.study.databinding.ActivityHashBinding

class HashActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Hash"
        binding.md5.setOnClickListener {
            val javaMd5= HashUtil.md5("Hello,World!")
            val nativeMd5= NativeHashUtil.md5("Hello,World!")
            binding.md5Text.text=String.format("Java实现： %s\n\nNative实现：%s",javaMd5,nativeMd5)
        }
        binding.sha1.setOnClickListener {
            val javaSHA1= HashUtil.sha1("Hello,World!")
            val nativeSHA1= NativeHashUtil.sha1("Hello,World!")
            binding.sha1Text.text=String.format("Java实现： %s\n\nNative实现：%s",javaSHA1,nativeSHA1)
        }
        binding.sha256.setOnClickListener {
            val javaSHA256= HashUtil.sha256("Hello,World!")
            val nativeSHA256= NativeHashUtil.sha256("Hello,World!")
            binding.sha256Text.text=String.format("Java实现： %s\n\nNative实现：%s",javaSHA256,nativeSHA256)
        }
    }
}