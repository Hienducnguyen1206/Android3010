package com.example.android3110

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextText2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonShow = findViewById<Button>(R.id.button2)
        val listView = findViewById<ListView>(R.id.danhsach)
        val errorTextView = findViewById<TextView>(R.id.errorTextView)

        buttonShow.setOnClickListener {
            errorTextView.text = ""
            val inputText = editText.text.toString()
            val n = inputText.toIntOrNull()


            if (n == null || n < 0) {
                errorTextView.text = "Vui lòng nhập một số nguyên dương"
                listView.adapter = null
                return@setOnClickListener
            }


            val results = when (radioGroup.checkedRadioButtonId) {
                R.id.sole -> generateOddNumbers(n)
                R.id.sochan -> generateEvenNumbers(n)
                R.id.sochinhphuong -> generatePerfectSquares(n)
                else -> {
                    errorTextView.text = "Vui lòng chọn loại số"
                    return@setOnClickListener
                }
            }


            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)
            listView.adapter = adapter
        }
    }


    private fun generateOddNumbers(n: Int): List<Int> {
        return (1..n step 2).toList()
    }


    private fun generateEvenNumbers(n: Int): List<Int> {
        return (0..n step 2).toList()
    }


    private fun generatePerfectSquares(n: Int): List<Int> {
        val result = mutableListOf<Int>()
        var i = 0
        while (i * i <= n) {
            result.add(i * i)
            i++
        }
        return result
    }
}
