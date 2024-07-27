package com.aliozdemir.helloandroid

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class CameraComponentNew1 : DefaultLifecycleObserver {

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        startCamera()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)

        stopCamera()
    }

    private fun startCamera() {
        Log.e("CameraComponent1", "startCamera")
    }

    private fun stopCamera() {
        Log.e("CameraComponent1", "stopCamera")
    }

}