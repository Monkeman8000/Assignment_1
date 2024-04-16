package com.example.assignmet1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
   private val historicalFigures = mutableListOf(
        "Leonardo da Vinci",
        "Martin Luther King Jr.",
        "Queen Elizabeth II",
        "Mahatma Gandhi",
        "Nelson Mandela",
        "Winston Churchill",
        "Che Guevara",
        "Albert Einstein",
        "Napoleon Bonaparte",
        "Leon Trotsky"
    )

    private val ages = mapOf(
        "Leonardo da Vinci" to 76,
        "Martin Luther King Jr." to 39,
        "Queen Elizabeth II" to 96,
        "Mahatma Gandhi" to 78,
        "Nelson Mandela" to 95,
        "Winston Churchill" to 90,
        "Che Guevara" to 39,
        "Albert Einstein" to 76,
        "Napoleon Bonaparte" to 51,
        "Leon Trotsky" to 60
    )
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageInput = findViewById<EditText>(R.id.ageInput)
        val textView = findViewById<TextView>(R.id.textView)
        val btngenerate = findViewById<Button>(R.id.button)
        val btnclear = findViewById<Button>(R.id.button2)
        btngenerate.setOnClickListener {
            val userAge = ageInput.text.toString().toIntOrNull()

            btnclear.setOnClickListener {
                ageInput.text.clear()
            }


            if (userAge != null) {
                val oldestFigure = ages.filter { it.value <= userAge }.maxByOrNull { it.value }?.key

                if (oldestFigure != null) {
                    textView.text = "Oldest Historical Figure: $oldestFigure"
                } else {
                    textView.text = "No historical figures found for the entered age."
                }
            } else {

                textView.text = "Please enter a valid age."
            }    }
    }
}