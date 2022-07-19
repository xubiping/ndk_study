package com.test.ndk.study.cpp.useDataType

object NativeUtil {
    external fun getNativeArray():BooleanArray
    external fun formatArray(intArray:IntArray):String
    external fun calcScorePass(yourScore:FloatArray):Array<String>
    external fun calcTotalMoney(price:DoubleArray):String
    external fun javaClassTest():User

}