package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edtData : EditText
    lateinit var btnStart : Button
    lateinit var btnStop : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtData = findViewById(R.id.edtData)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)

        btnStart.setOnClickListener(){
            clickStartService()
        }
        btnStop.setOnClickListener(){
            clickStopService()
        }
    }

    private fun clickStartService() {
        var intent = Intent(this,MyService::class.java)
        intent.putExtra("key_data",edtData.getText().toString().trim())
        startService(intent)
    }

    private fun clickStopService() {
        var intent = Intent(this,MyService::class.java)
        stopService(intent)
    }
}