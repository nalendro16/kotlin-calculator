package com.example.volumekubus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object{
        private  const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_hitung)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }

    }

    override fun onClick(v: View?) {
        if( v?.id == R.id.btn_hitung){
            val panjang = edtLength.text.toString().trim()
            val lebar = edtWidth.text.toString().trim()
            val tinggi = edtHeight.text.toString().trim()
        }
        if(v?.id == R.id.btn_hitung){
            val inputPanjang = edtLength.text.toString().trim()
            val inputLebar = edtWidth.text.toString().trim()
            val inputTinggi = edtHeight.text.toString().trim()

            var isEmpty = false

            if (inputPanjang.isEmpty()){
                isEmpty = true
                edtLength.error = "Field ini tidak boleh kosong"
            }
            if (inputLebar.isEmpty()){
                isEmpty = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (inputTinggi.isEmpty()){
                isEmpty = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            if(!isEmpty){
                val volume = inputPanjang.toDouble()*inputLebar.toDouble()*inputTinggi.toDouble()
                tvResult.text = volume.toString()
            }

        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}