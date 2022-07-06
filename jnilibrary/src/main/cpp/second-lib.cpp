#include <jni.h>
#include <string>

jint sum(jint a, jint i);

extern "C"
JNIEXPORT jint JNICALL
Java_com_start_jni_JniTest_add(JNIEnv *env, jobject thiz, jint a, jint b) {
    return sum(a,b);
}

jint sum(jint a, jint b) {

    return a+b;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_start_jni_JniTest_sub(JNIEnv *env, jobject thiz, jint a, jint b) {
    return a-b;
}