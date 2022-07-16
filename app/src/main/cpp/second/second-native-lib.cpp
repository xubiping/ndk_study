#include <jni.h>
#include <string>
#include <android/log.h>
#define  LOG_TAG "C_TAG"
#define  LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)

extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaBooleanToNative(JNIEnv *env, jobject thiz,
        jboolean value) {
    LOGD("Java Boolean: %d",value);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaByteToNative(JNIEnv *env, jobject thiz,
                                                               jbyte value) {
    LOGD("Java Byte: %d",value);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaCharToNative(JNIEnv *env, jobject thiz,
                                                               jchar value) {
    LOGD("Java Char: %c",value);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaShortToNative(JNIEnv *env, jobject thiz,
                                                                jshort value) {
    LOGD("Java Short: %d",value);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaInttoNative(JNIEnv *env, jobject thiz,
                                                              jint value) {
    LOGD("Java Int: %d",value);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaLongToNative(JNIEnv *env, jobject thiz,
                                                               jlong value) {
    LOGD("Java Long: %lld",value);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaFloatToNative(JNIEnv *env, jobject thiz,
                                                                jfloat value) {
    LOGD("Java Float: %f",value);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaDoubleToNative(JNIEnv *env, jobject thiz,
                                                                 jdouble value) {
    LOGD("Java Double: %lf",value);
}



extern "C"
JNIEXPORT jboolean JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaBooleanFromNative(JNIEnv *env, jobject thiz) {
    return true;
}
extern "C"
JNIEXPORT jbyte JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaByteFromNative(JNIEnv *env, jobject thiz) {
    return 8;
}
extern "C"
JNIEXPORT jchar JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaCharFromNative(JNIEnv *env, jobject thiz) {
    return 'd';
}
extern "C"
JNIEXPORT jshort JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaShortFromNative(JNIEnv *env, jobject thiz) {
    return 9;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaIntFromNative(JNIEnv *env, jobject thiz) {
    return 99;
}
extern "C"
JNIEXPORT jlong JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaLongFromNative(JNIEnv *env, jobject thiz) {
    return 999;
}
extern "C"
JNIEXPORT jfloat JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaFloatFromNative(JNIEnv *env, jobject thiz) {
    return 9999;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_javaDoubleFromNative(JNIEnv *env, jobject thiz) {
    return 99999;
}



extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_charConcatTest(JNIEnv *env, jobject thiz, jchar a,
                                                             jchar b, jchar c) {
    LOGD("charConcatTest cpp 1");
    char charArray[4];
    charArray[0]=a;
    charArray[1]=b;
    charArray[2]=c;
    charArray[3]='\0';
    LOGD("charConcatTest cpp 2");
    return env->NewStringUTF(charArray);
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_sumText(JNIEnv *env, jobject thiz, jint i, jint j) {
    return i+j;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_twoExpTest(JNIEnv *env, jobject thiz, jint exp) {
    return pow(2,exp);
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_cpp_second_NativeUtil_calcMoneyText(JNIEnv *env, jobject thiz, jdouble v,
                                                            jdouble v1, jdouble v2) {
    double totalMoney = v+v1+v2;
    char *resultStr = new char ();
    sprintf(resultStr,"总结：%f",totalMoney);
    return env->NewStringUTF(resultStr);
}