package com.example.calculations

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1EditText: EditText = findViewById(R.id.number1)
        val number2EditText: EditText = findViewById(R.id.number2)
        val operationSpinner: Spinner = findViewById(R.id.operationSpinner)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toIntOrNull()
            val number2 = number2EditText.text.toString().toIntOrNull()
            val operation = operationSpinner.selectedItem.toString()

            if (number1 == null || number2 == null) {
                resultTextView.text = "Please enter valid numbers"
                return@setOnClickListener
            }

            val result = when (operation) {
                "Addition" -> sum(number1, number2)
                "Subtraction" -> subtract(number1, number2)
                "Multiplication" -> multiply(number1, number2)
                "Division" -> {
                    if (number2 == 0) {
                        resultTextView.text = "Cannot divide by zero"
                        return@setOnClickListener
                    } else {
                        divide(number1, number2)
                    }
                }
                else -> 0
            }

            resultTextView.text = "Result: $result"
        }
    }

    public fun sum(a: Int, b: Int): Int {
        return a + b
    }

    public fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    public fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    public fun divide(a: Int, b: Int): Int {
        return a / b
    }
}