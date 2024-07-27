package com.aliozdemir.helloandroid

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class CameraComponentDeprecated : LifecycleObserver {   // Reflection kullandığı için maliyetli bir yöntem.

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun startCamera() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun stopCamera() {

    }

}