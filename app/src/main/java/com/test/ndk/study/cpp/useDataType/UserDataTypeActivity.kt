package com.test.ndk.study.cpp.useDataType

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.test.ndk.study.databinding.ActivityUserdatatypeBinding

class UserDataTypeActivity : AppCompatActivity() {
    private lateinit var binder :ActivityUserdatatypeBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityUserdatatypeBinding.inflate(layoutInflater)
        setContentView(binder.root)
        title = "数据类型使用"
        /**
         * 从 Native 获取数组，Java进行格式化
         */
        binder.getNativeArray.setOnClickListener {
            val nativeArray = NativeUtil.getNativeArray()
            val stringBuilder = StringBuffer("[")
            for (i in nativeArray.indices){
                stringBuilder.append(nativeArray[i])
                if (i != nativeArray.size -1){
                    stringBuilder.append(", ")
                }
            }
            stringBuilder.append("]")
            binder.getNativeArrayText.text = stringBuilder.toString()

        }

        /**
         * 将 Java 数组传入 Native，Native 格式化
         */
        binder.formatArray.setOnClickListener {
            var intArray = intArrayOf(11,22,33,44,55)
            var formatArrayStr = NativeUtil.formatArray(intArray)
            binder.formatArrayText.text = formatArrayStr
        }

        /**
         * 计算机各科成绩是否通过
         */
        binder.calcScorePass.setOnClickListener {
            val yourScore = floatArrayOf(59.0F,88.0F,76.5F,45.0F,98.0F)
            val yourScoreResult = NativeUtil.calcScorePass(yourScore)
            val stringBuilder = StringBuffer("[")
            for (i in yourScore.indices){
                stringBuilder.append(yourScore[i])
                if(i != yourScore.size -1){
                    stringBuilder.append(",")
                }
            }
            stringBuilder.append("]")
            stringBuilder.append("\n")

            stringBuilder.append("[")
            for (i in yourScoreResult.indices){
                stringBuilder.append(yourScoreResult[i])
                if(i != yourScoreResult.size -1){
                    stringBuilder.append(",")
                }
            }
            stringBuilder.append("]")
            stringBuilder.append("\n")
            binder.calcScorePassText.text = stringBuilder.toString()
        }

        /**
         * Native 计算商品总结
         */
        binder.calcTotalMoney.setOnClickListener {
            val price = doubleArrayOf(5.5,6.6,7.7,8.8,9.9)
            val resultStr = NativeUtil.calcTotalMoney(price)
            binder.calcTotalMoneyText.text = resultStr
        }

        binder.javaClassTest.setOnClickListener {
            val userFromNative = NativeUtil.javaClassTest()
            val stringBuilder = StringBuffer()
            stringBuilder.append("{\n")
            stringBuilder.append(String.format("\t\"name\": \"%s\",\n", userFromNative.name))
            stringBuilder.append(String.format("\t\"age\": %d\n", userFromNative.age))
            stringBuilder.append("}")
            Log.v("javaClassTest ",stringBuilder.toString());
            binder.javaClassTest.text = stringBuilder.toString()

        }

    }


}