package com.example.arithmeticprogram

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // initialized variables
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // found ids and set it to variables
        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        radioGroup = findViewById(R.id.radio_group)
        result = findViewById(R.id.result)

        val calculateButton: Button = findViewById(R.id.button)
        calculateButton.setOnClickListener {
            // if calculateButton is clicked, call the calculate() function
            calculate()
        }
    }
    private fun calculate() {
        // get user input from EditTexts
        val operand1String = input1.text.toString()
        val operand2String = input2.text.toString()

        if (operand1String.isNotEmpty() && operand2String.isNotEmpty()) {
            //check if inputs are not empty

            //convert strings to doubles
            val operand1 = operand1String.toDouble()
            val operand2 = operand2String.toDouble()

            // get selected radio button id from RadioGroup
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId

            // Perform calculation based on the selected radio button
            val resultValue = if (selectedRadioButtonId == R.id.addition) {
                operand1 + operand2
            } else if (selectedRadioButtonId == R.id.subtraction) {
                operand1 - operand2
            } else if (selectedRadioButtonId == R.id.multiplication) {
                operand1 * operand2
            } else if (selectedRadioButtonId == R.id.division) {
                if (operand2 != 0.0){
                    // check if second input is not 0
                    operand1 / operand2
                } else{
                    "Divide by Zero not allowed!"
                }
            } else if (selectedRadioButtonId == R.id.modulus) {
                if (operand2 != 0.0){
                    // check if second input is not 0
                    operand1 % operand2
                } else{
                    "Modulus by Zero not allowed!"
                }
            } else {
                "Invalid operation!"
            }

            // display result
            result.text = "$resultValue"

        }else{
            // handle empty inputs
            result.text = "Error! Missing one or more inputs"
        }
    }
}
