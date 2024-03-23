package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textView_result)
        val tvClassficacao = findViewById<TextView>(R.id.textView_classificacao)

        val result = intent.getFloatExtra("Extra_Result", 0.1f)

        tvResult.text = result.toString()


        val classificacao = if(result < 18.5f){
            "Abaixo do Peso"
        }else if (result > 18.5f && result <= 24.99f){
            "Normal"
        }else if (result > 25.00f && result <= 29.99f){
            "Sobrepeso"
        }else if (result > 30.00f && result <= 39.99f){
            "Obesidade"
        }else {
            "Obesidade Grave"
        }
        tvClassficacao.text = getString(R.string.message_classificacao, classificacao)


        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)

    }
    }
