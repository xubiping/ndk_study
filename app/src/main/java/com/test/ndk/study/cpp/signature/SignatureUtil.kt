package com.test.ndk.study.cpp.signature

import android.content.Context
import android.content.pm.PackageManager.GET_SIGNATURES
import java.security.MessageDigest

object SignatureUtil {
     fun getSignatureStr(context: Context):String{
        val signature = getSignature(context)
         //?.意思是这个参数可以为空,并且程序继续运行下去
         //!!.的意思是这个参数如果为空,就抛出异常
         //val cert = signature?.toByteArray()
         val cert = signature!!.toByteArray()
         val md5 = MessageDigest.getInstance("MD5")
         val sha1 = MessageDigest.getInstance("SHA1")
         val sha256 = MessageDigest.getInstance("SHA256")
         val md5Key = md5.digest(cert)
         val sha1Key = sha1.digest(cert)
         val sha256Key = sha256.digest(cert)
         return String.format("MD5: %s\n\nSHA1: %s\n\nSHA-256: %s",
                byteArrayToString(md5Key),
                byteArrayToString(sha1Key),
                byteArrayToString(sha256Key))

     }
    fun getSignature(context: Context): android.content.pm.Signature? {
        val packageName = context.packageName
        val packageManager = context.packageManager
        val packageInfo = packageManager.getPackageInfo(packageName, GET_SIGNATURES)
        val signatures = packageInfo.signatures
        return signatures[0]
    }
    fun byteArrayToString(array:ByteArray):String{
        val hexString = StringBuilder();
        for (i in array.indices){
            val appendString = Integer.toHexString(0xFF and array[i].toInt()).toUpperCase()
            if(appendString.length ==1){
                hexString.append(0)
            }
            hexString.append(appendString)
            if(i<array.size -1)
                hexString.append(":")
        }
        return hexString.toString()
    }
}