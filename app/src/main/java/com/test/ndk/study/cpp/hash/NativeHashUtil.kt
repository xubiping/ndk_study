package com.test.ndk.study.cpp.hash

object NativeHashUtil {
    external fun md5(plaintext:String):String
    external fun sha1(plaintext:String):String
    external fun sha256(plaintext:String):String
}