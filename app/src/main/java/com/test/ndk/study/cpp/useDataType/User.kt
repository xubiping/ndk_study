package com.test.ndk.study.cpp.useDataType

class User {
    var normalField:Int = 99

    val normalUserInfo:String
        get() = "[name:hubin,age:28]"
    var name:String = ""
    var age =0
    constructor(){

    }
    constructor(name:String,age:Int){
        this.name = name
        this.age = age
    }
    val formatInfo:String
        get() = String.format("[name:%s,age:%d]",name,age)
    companion object {
        var staticField = 88
        val staticUserInfo:String
            get() = "[name:hubin,age:18]"
    }

}