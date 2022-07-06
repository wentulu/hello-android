package com.start.jni

class JniTest {
    external fun add(a:Int, b:Int) : Int

    external fun sub(a:Int, b:Int):Int

    companion object {
//        init {
//            System.loadLibrary("second-lib")
//        }
    }
}