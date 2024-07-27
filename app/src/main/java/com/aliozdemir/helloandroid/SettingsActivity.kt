package com.aliozdemir.helloandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        //super.onBackPressed() i çağırmazsak süreci kendimiz yönetiyoruz.
        val callback = object : OnBackPressedCallback(true) {  // true olursa -> bu değer false olana kadar BackPressed'i ben handle ediyorum, super'ini çağırma diyoruz.
            // super'ini çağırmak istersek değeri false yapmamız gerekiyor.
            override fun handleOnBackPressed() {
                Log.d("SettingsActivity", "onBackPressed")

                counter++
                if (counter <= 1) {
                    Toast.makeText(this@SettingsActivity, "Çıkmak için bir daha tıkla", Toast.LENGTH_SHORT).show()
                    isEnabled = false
                }
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)
    }

//    override fun onBackPressed() {
//        Log.d("SettingsActivity", "onBackPressed")
//
//        counter++
//        if (counter <= 1) {
//            Toast.makeText(this, "Çıkmak için bir daha tıkla", Toast.LENGTH_SHORT).show()
//        } else {
//            super.onBackPressed()   // Bu super fonk. çağırmazsak, asıl yapması gereken işi engellemiş oluruz.
//        }
//    }

}