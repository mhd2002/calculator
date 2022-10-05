package com.example.calculator

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class Calculator : AppCompatActivity() {

    val ids = arrayOf(
        R.id.num_dot,
        R.id.num_zero,
        R.id.num_back,
        R.id.num_equal,
        R.id.num_one,
        R.id.num_two,
        R.id.num_three,
        R.id.num_plus,
        R.id.num_four,
        R.id.num_five,
        R.id.num_six,
        R.id.num_min,
        R.id.num_seven,
        R.id.num_eight,
        R.id.num_nine,
        R.id.num_mul,
        R.id.num_clear,
        R.id.num_start_bracket,
        R.id.num_end_bracket,
        R.id.num_div,
        R.id.tv_answer,
        R.id.placeholder
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val num_dot = findViewById<TextView>(ids[0])
        val num_zero = findViewById<TextView>(ids[1])
        val num_back = findViewById<TextView>(ids[2])
        val num_equal = findViewById<TextView>(ids[3])
        val num_one = findViewById<TextView>(ids[4])
        val num_two = findViewById<TextView>(ids[5])
        val num_three = findViewById<TextView>(ids[6])
        val num_plus = findViewById<TextView>(ids[7])
        val num_four = findViewById<TextView>(ids[8])
        val num_five = findViewById<TextView>(ids[9])
        val num_six = findViewById<TextView>(ids[10])
        val num_min = findViewById<TextView>(ids[11])
        val num_seven = findViewById<TextView>(ids[12])
        val num_eight = findViewById<TextView>(ids[13])
        val num_nine = findViewById<TextView>(ids[14])
        val num_mul = findViewById<TextView>(ids[15])
        val num_claer = findViewById<TextView>(ids[16])
        val num_start_brack = findViewById<TextView>(ids[17])
        val num_end_brack = findViewById<TextView>(ids[18])
        val num_div = findViewById<TextView>(ids[19])
        val placeholder = findViewById<TextView>(ids[21])



        num_dot.setOnClickListener { text(".") }
        num_zero.setOnClickListener { text("0") }
        num_one.setOnClickListener { text("1") }
        num_two.setOnClickListener { text("2") }
        num_three.setOnClickListener { text("3") }
        num_four.setOnClickListener { text("4") }
        num_five.setOnClickListener { text("5") }
        num_six.setOnClickListener { text("6") }
        num_seven.setOnClickListener { text("7") }
        num_eight.setOnClickListener { text("8") }
        num_nine.setOnClickListener { text("9") }

        num_plus.setOnClickListener { text("+") }
        num_min.setOnClickListener { text("-") }
        num_mul.setOnClickListener { text("*") }
        num_div.setOnClickListener { text("/") }
        num_start_brack.setOnClickListener { text("(") }
        num_end_brack.setOnClickListener { text(")") }

        num_claer.setOnClickListener { placeholder.text = "" }
        num_back.setOnClickListener {

            val text = placeholder.text.toString()

            if (text.isNotEmpty()) {
                placeholder.text = text.substring(0, text.length - 1)
            }
        }

        num_equal.setOnClickListener {

            theAnswer(placeholder.text.toString())

        }

    }

    private fun theAnswer(string: String) {
        val answer = findViewById<TextView>(ids[20])

        try {

            val process = ExpressionBuilder(string).build()
            val result = process.evaluate()
            answer.text = result.toString()

        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }

    }

    private fun text(string: String) {
        val placeholder = findViewById<TextView>(ids[21])

        placeholder.append(string)

    }

}