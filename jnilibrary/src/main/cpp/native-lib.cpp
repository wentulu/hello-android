#include <jni.h>
#include <string>
extern int print();

extern "C" JNIEXPORT jstring JNICALL
Java_com_start_jni_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    print();
    return env->NewStringUTF(hello.c_str());
}