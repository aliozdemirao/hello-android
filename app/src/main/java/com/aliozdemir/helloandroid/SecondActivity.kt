package com.aliozdemir.helloandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("SecondActivityLifecycle", "onCreate1")

        setContentView(R.layout.activity_second)

        Log.d("SecondActivityLifecycle", "onCreate2")


        val param = intent.getStringExtra("key") ?: "default value"
        Log.e("ActivityLifecycle Data", param)

        val bundle = intent.extras
        val paramBundle = bundle?.getString("keyBundle", "default value") ?: "bundle null"
        Log.e("ActivityLifecycle Bundle Data", paramBundle)
    }

    override fun onContentChanged() {
        super.onContentChanged()

        Log.d("SecondActivityLifecycle", "onContentChanged")
    }

    override fun onStart() {
        super.onStart()

        Log.d("SecondActivityLifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("SecondActivityLifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("SecondActivityLifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("SecondActivityLifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("SecondActivityLifecycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("SecondActivityLifecycle", "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.d("SecondActivityLifecycle", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d("SecondActivityLifecycle", "onRestoreInstanceState")
    }

    override fun onBackPressed() {
        super.onBackPressed()

        Log.d("SecondActivityLifecycle", "onBackPressed")
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()

        Log.d("SecondActivityLifecycle", "onUserLeaveHint")       // Home button ya da Recent Apps list tıklanınca
    }

    override fun onUserInteraction() {
        super.onUserInteraction()

        Log.d("SecondActivityLifecycle", "onUserInteraction")     // Kullanıcı UI ile etkileşime geçiyor
    }

}