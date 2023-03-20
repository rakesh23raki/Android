//
// Created by rguddeti on 3/10/2023.
//



#include<iostream>
#include<string>
#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_kotlinretrofit_MainActivity_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string key = "NkxmMVJTUWtBQUFBQUVaSlVoUXd3d25vaUZlblNYNkNKZWpiM29vMQ==";
    return env->NewStringUTF(key.c_str());
}