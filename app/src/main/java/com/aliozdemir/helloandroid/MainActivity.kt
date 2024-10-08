package com.aliozdemir.helloandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnOpenSettingsActivity: Button

    private val cameraComponentNew1 = CameraComponentNew1()
    private val cameraComponentNew2 = CameraComponentNew2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("ActivityLifecycle", "onCreate1")

        setContentView(R.layout.activity_main)  // onContentChanged() tetiklenir.

        Log.d("ActivityLifecycle", "onCreate2")

        val btnOpenSecondActivity = findViewById<Button>(R.id.btnOpenSecondActivity)
        btnOpenSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            // 1. yol
            intent.putExtra("key", "value")

            // 2. yol
            val bundle = Bundle()
            bundle.putString("keyBundle", "valueBundle")
            intent.putExtras(bundle)

            startActivity(intent)
            finish()
        }

        lifecycle.addObserver(cameraComponentNew1)
        lifecycle.addObserver(cameraComponentNew2)

        btnOpenSettingsActivity = findViewById(R.id.btnOpenSettingsActivity)
        btnOpenSettingsActivity.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onContentChanged() {
        super.onContentChanged()

        Log.d("ActivityLifecycle", "onContentChanged")
    }

    override fun onStart() {
        super.onStart()

        Log.d("ActivityLifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("ActivityLifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("ActivityLifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("ActivityLifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("ActivityLifecycle", "onDestroy")

        lifecycle.removeObserver(cameraComponentNew1)
        lifecycle.removeObserver(cameraComponentNew2)
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("ActivityLifecycle", "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val etUserField = findViewById<EditText>(R.id.etUserField)
        val userField = etUserField.text.toString()

        outState.putString("userField", userField)

        Log.d("ActivityLifecycle", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val userField = savedInstanceState.getString("userField")
        val etUserField = findViewById<EditText>(R.id.etUserField)

        etUserField.setText(userField)

        Log.d("ActivityLifecycle", "onRestoreInstanceState")
    }

    override fun onBackPressed() {
        super.onBackPressed()

        Log.d("ActivityLifecycle", "onBackPressed")
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()

        Log.d("ActivityLifecycle", "onUserLeaveHint")       // Home button ya da Recent Apps list tıklanınca
    }

    override fun onUserInteraction() {
        super.onUserInteraction()

        Log.d("ActivityLifecycle", "onUserInteraction")     // Kullanıcı UI ile etkileşime geçiyor
    }

    fun someBusinessLogic(name: String?, surname: String?): String {
        return "Hello $name $surname"
    }

}