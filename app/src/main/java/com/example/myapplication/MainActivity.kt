package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edtText_peso)
        val edtAltura: EditText = findViewById(R.id.edtText_altura)


        btnCalcular.setOnClickListener() {
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                var height: Float =alturaStr.toFloat()
                var weight: Float =pesoStr.toFloat()
                var IMC: Float = (weight / (height * height))


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("Extra_Result", IMC)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
