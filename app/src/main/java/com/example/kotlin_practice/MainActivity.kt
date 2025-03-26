package com.example.kotlin_practice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edit = findViewById<EditText>(R.id.edit)
        val btn = findViewById<Button>(R.id.btn)
        val tv = findViewById<TextView>(R.id.tv)
        val xbtn = findViewById<Button>(R.id.xbtn)

        btn.setOnClickListener {
            tv.text = edit.text.toString()
        }

        xbtn.setOnClickListener {
            edit.text.clear()  // EditText 문자열 삭제
            tv.text = ""       // TextView 내용 삭제
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}