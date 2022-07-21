package com.test.ndk.study.cpp.signature

import android.content.Context

object NativeSignatureUtil {
    external fun getSignature(context:Context):String
    external fun checkSignature(context:Context):String
}