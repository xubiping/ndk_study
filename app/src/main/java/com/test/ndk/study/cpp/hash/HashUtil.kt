package com.test.ndk.study.cpp.hash

import java.security.MessageDigest


object HashUtil {
    fun md5(plainText:String):String{
        try {
            val md5 = MessageDigest.getInstance("MD5")
            val md5Byte = md5.digest(plainText.toByteArray())
            return byteArrayToString(md5Byte)
        }catch (e:Exception){
            return ""
        }
    }
    fun sha1(plainText:String):String{
        try {
            val sha1 = MessageDigest.getInstance("SHA1")
            val sha1Byte = sha1.digest(plainText.toByteArray())
            return byteArrayToString(sha1Byte)
        }catch (e:Exception){
            return ""
        }
    }
    fun sha256(plainText:String):String{
        try {
            val sha256 = MessageDigest.getInstance("SHA256")
            val sha256Byte = sha256.digest(plainText.toByteArray())
            return byteArrayToString(sha256Byte)
        }catch (e:Exception){
            return ""
        }
    }

    fun byteArrayToString(array:ByteArray):String{
        val hexString = StringBuffer()
        for (i in array.indices){
            val appendString = Integer.toHexString(0xFF and array[i].toInt()).toUpperCase()
            if (appendString.length ==1){
                hexString.append("0")
            }
            hexString.append(appendString)
            if(i<array.size -1){
                hexString.append(":")
            }
        }
        return hexString.toString()
    }
}