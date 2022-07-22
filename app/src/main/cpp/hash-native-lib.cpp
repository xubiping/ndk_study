#include <jni.h>
#include <string>
#include "hash_library/md5.h"
#include "hash_library/sha1.h"
#include "hash_library/sha256.h"

void formatSignatureHash(char *data,char *resultData);
extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_cpp_hash_NativeHashUtil_md5(JNIEnv *env, jobject thiz, jstring plaintext) {
    const char * plaintextChar = env->GetStringUTFChars(plaintext, 0);
    std::string plaintextStr = std::string(plaintextChar);
    MD5 md5;
    std::string md5String = md5(plaintextStr);
    char * tabStr = new char [md5String.length()+1];
    strcpy(tabStr, md5String.c_str());
    char md5Result[128] = {0};
    formatSignatureHash(tabStr, md5Result);
    return env->NewStringUTF(md5Result);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_cpp_hash_NativeHashUtil_sha1(JNIEnv *env, jobject thiz, jstring plaintext) {
    const char * plaintextChar = env->GetStringUTFChars(plaintext, 0);
    std::string plaintextStr = std::string(plaintextChar);
    SHA1 sha1;
    std::string sha1String = sha1(plaintextStr);
    char * tabStr = new char [sha1String.length()+1];
    strcpy(tabStr, sha1String.c_str());
    char sha1Result[128] = {0};
    formatSignatureHash(tabStr, sha1Result);
    return env->NewStringUTF(sha1Result);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_test_ndk_study_cpp_hash_NativeHashUtil_sha256(JNIEnv *env, jobject thiz,
                                                       jstring plaintext) {
    const char * plaintextChar = env->GetStringUTFChars(plaintext, 0);
    std::string plaintextStr = std::string(plaintextChar);
    SHA256 sha256;
    std::string sha256String = sha256(plaintextStr);
    char * tabStr = new char [sha256String.length()+1];
    strcpy(tabStr, sha256String.c_str());
    char sha256Result[128] = {0};
    formatSignatureHash(tabStr, sha256Result);
    return env->NewStringUTF(sha256Result);
}


void formatSignatureHash(char *data,char *resultData){
    int resultIndex =0;
    int length = strlen(data);
    for(int i = 0; i<length;i++){
        resultData[resultIndex] = static_cast<char>(toupper(data[i]));
        if(i % 2 ==1 &&i !=length-1) {
            resultData[resultIndex+1] = ':';
            resultIndex+=2;
        }else{
            resultIndex++;
        }
    }
}