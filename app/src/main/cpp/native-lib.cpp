#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "first C++";
    return env->NewStringUTF(hello.c_str());
}