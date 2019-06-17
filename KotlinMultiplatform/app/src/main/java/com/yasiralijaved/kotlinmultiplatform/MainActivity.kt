package com.yasiralijaved.kotlinmultiplatform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yasiralijaved.kotlinmultiplatform.shared.ApplicationApi
import com.yasiralijaved.kotlinmultiplatform.shared.createApplicationScreenMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)

        val api = ApplicationApi()

        api.users {
            GlobalScope.apply {
                launch (Dispatchers.Main) {
                    textView.text = it
                }
            }
        }
    }
}
