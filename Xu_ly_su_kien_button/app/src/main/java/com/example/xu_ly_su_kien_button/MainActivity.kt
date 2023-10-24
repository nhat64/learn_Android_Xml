package com.example.xu_ly_su_kien_button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var textA : EditText
    private lateinit var textB : EditText
    private lateinit var textResult : EditText

    private lateinit var btnAdd : Button
    private lateinit var btnReset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textA = findViewById(R.id.editTextA)
        textB = findViewById(R.id.editTextB)
        textResult = findViewById(R.id.editTextResult)

        btnAdd = findViewById(R.id.btnAdd)
        btnReset = findViewById(R.id.btnReset)

        btnAdd.setOnClickListener {
            val a: Int = textA.text.toString().toInt()
            val b: Int = textB.text.toString().toInt()
            val result : Int = a + b
            textResult.setText(result.toString())
        }

        btnReset.setOnClickListener {
            textA.setText("")
            textB.setText("")
            textResult.setText("")
        }
    }
}