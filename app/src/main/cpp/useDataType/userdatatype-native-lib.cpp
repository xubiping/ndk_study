#include <jni.h>
#include "string"
#include <android/log.h>
#define  LOG_TAG "C_TAG"
#define  LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)


extern "C"
JNIEXPORT jbooleanArray JNICALL
Java_com_test_ndk_study_cpp_useDataType_NativeUtil_getNativeArray(JNIEnv *env, jobject thiz) {
    jboolean *jb = new jboolean [5];
    jb[0]= JNI_TRUE;
    jb[1]= JNI_FALSE;
    jb[2]= JNI_TRUE;
    jb[3]= JNI_FALSE;
    jb[4]= JNI_TRUE;
    jbooleanArray jba = env->NewBooleanArray(5);
    env->SetBooleanArrayRegion(jba,0,5,jb);
    return jba;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_cpp_useDataType_NativeUtil_formatArray(JNIEnv *env, jobject thiz,
                                                               jintArray int_array) {
    jint array[5];
    env->GetIntArrayRegion(int_array,0,5,array);
    jsize size = env->GetArrayLength(int_array);
    char resutStr[100] = {0};
    char str[10] = {0};
    strcat(resutStr,"[");
    for (int i = 0; i < size; ++i) {
        sprintf(str,"%d",array[i]);
        strcat(resutStr,str);
        if(i != size -1){
            strcat(resutStr,", ");
        }
    }
    strcat(resutStr,"]");
    return env->NewStringUTF(resutStr);

}
extern "C"
JNIEXPORT jobjectArray JNICALL
Java_com_test_ndk_study_cpp_useDataType_NativeUtil_calcScorePass(JNIEnv *env, jobject thiz,
                                                                 jfloatArray your_score) {
    jfloat array[5];
    env->GetFloatArrayRegion(your_score,0,5,array);
    jsize size =env->GetArrayLength(your_score);

    jclass objClass = env->FindClass("java/lang/String");
    jobjectArray objArray = env->NewObjectArray(5,objClass,0);
    jstring jstr;
    for (int i = 0;i<size;i++){
        if(array[i] >= 60.0){
            jstr = env->NewStringUTF("√");
        }else{
            jstr = env->NewStringUTF("x");
        }
        env->SetObjectArrayElement(objArray,i,jstr);
    }
    return objArray;
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_cpp_useDataType_NativeUtil_calcTotalMoney(JNIEnv *env, jobject thiz,
                                                                  jdoubleArray price) {
    jdouble array[5];
    env->GetDoubleArrayRegion(price,0,5,array);
    jsize size= env->GetArrayLength(price);
    char resultStr[255] = {0};
    char str[20] = {0};
    strcat(resultStr,"sum(");
    jdouble  totalMoney = 0.0;
    for (int i=0;i<size;i++) {
        sprintf(str,"%.1f",array[i]);
        strcat(resultStr,str);
        if(i != size -1){
            strcat(resultStr,", ");
        }
        totalMoney += array[i];
    }
    strcat(resultStr,")");
    strcat(resultStr,"\n");
    sprintf(str,"%.1f",totalMoney);
    strcat(resultStr,str);
    return env->NewStringUTF(resultStr);
}
extern "C"
JNIEXPORT jobject JNICALL
Java_com_test_ndk_study_cpp_useDataType_NativeUtil_javaClassTest(JNIEnv *env, jobject thiz) {
    jclass userClass = env->FindClass("com/test/ndk/study/cpp/useDataType/User");

    jfieldID normalField = env->GetFieldID(userClass, "normalField", "I");
    jfieldID staticField = env->GetStaticFieldID(userClass, "staticField", "I");

    jmethodID normalMethod = env->GetMethodID(userClass, "getNormalUserInfo", "()Ljava/lang/String;");
    LOGD("javaClassTest: 0" );
    //kotlin 直接通过这种获取静态方法会崩溃，必须先获取 Companion 类
    //jmethodID staticMethod = env->GetStaticMethodID(userClass, "getStaticUserInfo", "()Ljava/lang/String;");

    //kotlin 获取静态方法 如下
    jclass companionClazz = env->FindClass("com/test/ndk/study/cpp/useDataType/User$Companion");
    jfieldID clazz_companionField = env->GetStaticFieldID(userClass,"Companion","Lcom/test/ndk/study/cpp/useDataType/User$Companion;");
    jobject companionObj = env->GetStaticObjectField(userClass ,clazz_companionField);

    jmethodID companionMethodID = env->GetMethodID(companionClazz,"getStaticUserInfo","()Ljava/lang/String;");


    LOGD("javaClassTest: 1" );
    jmethodID voidInitMethod = env->GetMethodID(userClass, "<init>", "()V");
    LOGD("javaClassTest: 2" );
    jmethodID paramInitMethod = env->GetMethodID(userClass, "<init>", "(Ljava/lang/String;I)V");
    LOGD("javaClassTest: 3" );
    jmethodID getFormatInfoMethod = env->GetMethodID(userClass, "getFormatInfo", "()Ljava/lang/String;");
    LOGD("javaClassTest: 4" );

    jobject userOne = env->NewObject(userClass, voidInitMethod);
    LOGD("javaClassTest: 5" );
    jstring name = env->NewStringUTF("HUBIN");
    jint age = 8;
    jobject userTwo = env->NewObject(userClass, paramInitMethod, name, age);
    LOGD("javaClassTest: 6" );
    jobject userThree = env->AllocObject(userClass);
    LOGD("javaClassTest: 7" );

    jint normalFieldValue = env->GetIntField(userOne, normalField);
    LOGD("normalField: %d", normalFieldValue);

    jint staticFieldValue = env->GetStaticIntField(userClass, staticField);
    LOGD("staticField: %d", staticFieldValue);

    jobject normalMethodResultObj = env->CallObjectMethod(userOne, normalMethod);
    jstring normalMethodResult = static_cast<jstring>(normalMethodResultObj);
    const char *normalMethodResultNativeString = env->GetStringUTFChars(normalMethodResult, 0);
    LOGD("normalMethodResult: %s", normalMethodResultNativeString);
    if(companionObj == NULL){
        LOGD("companionObj: null");
        return env->NewStringUTF("null");
    }
    if(companionMethodID == NULL){
        LOGD("companionMethodID: null");
        return env->NewStringUTF("null");
    }else{
        LOGD("companionMethodID: no null");
    }

    jobject staticMethodResultObj = (env)->CallObjectMethod(companionObj, companionMethodID);

    if(staticMethodResultObj == NULL){
        LOGD("staticMethodResultObj: null");
    }else{
        LOGD("staticMethodResultObj: not null");
    }
    jstring staticMethodResult = static_cast<jstring>(staticMethodResultObj);
    /*if(staticMethodResult == NULL){
        LOGD("staticMethodResult: null");
    }else{
        LOGD("staticMethodResult: %s", staticMethodResultObj);
    }*/
    const char *staticMethodResultNativeString = env->GetStringUTFChars(staticMethodResult, 0);
    if(staticMethodResultNativeString == NULL){
        LOGD("staticMethodResultNativeString: null");
    }else{
        LOGD("staticMethodResultNativeString: %s", staticMethodResultNativeString);
    }
    jobject getFormatInfoMethodResultObj = env->CallObjectMethod(userTwo, getFormatInfoMethod);
    jstring getFormatInfoMethodResult = static_cast<jstring>(getFormatInfoMethodResultObj);
    //jstring 一定要通过 下面char转直接输出string 会崩溃
    const char *getFormatInfoMethodResultNativeString = env->GetStringUTFChars(getFormatInfoMethodResult, 0);
    LOGD("getFormatInfoMethodResult: %s", getFormatInfoMethodResultNativeString);

    jobject userThreeMethodResultObj = env->CallObjectMethod(userThree, normalMethod);
    jstring userThreeMethodResult = static_cast<jstring>(userThreeMethodResultObj);
    const char *userThreeMethodResultNativeString = env->GetStringUTFChars(userThreeMethodResult, 0);
    LOGD("userThreeMethodResult: %s", userThreeMethodResultNativeString);


    jstring ygName = env->NewStringUTF("老妖怪");
    jint ygAge = 999;
    jobject userYG = env->NewObject(userClass, paramInitMethod, ygName, ygAge);
    return userYG;
}
