package com.test.ndk.study.cpp.second

class NativeUtil {
    external fun javaBooleanToNative(value:Boolean)
    external fun javaByteToNative(value: Byte)
    external fun javaCharToNative(value:Char)
    external fun javaShortToNative(value:Short)
    external fun javaInttoNative(value:Int)
    external fun javaLongToNative(value:Long)
    external fun javaFloatToNative(value:Float)
    external fun javaDoubleToNative(value:Double)


    external fun javaBooleanFromNative():Boolean
    external fun javaByteFromNative():Byte
    external fun javaCharFromNative():Char
    external fun javaShortFromNative():Short
    external fun javaIntFromNative():Int
    external fun javaLongFromNative():Long
    external fun javaFloatFromNative():Float
    external fun javaDoubleFromNative():Double

    external fun charConcatTest(a:Char,b:Char,c:Char):String
    external fun sumText(i:Int,j:Int):Int
    external fun twoExpTest(exp:Int):Int
    external fun calcMoneyText(v:Double,v1:Double,v2:Double):String

}