package com.example.imcapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    lateinit var cxHomem : RadioButton
    lateinit var cxMulher: RadioButton
    lateinit var calcImc : Button
    lateinit var altura : EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        altura = findViewById(R.id.txtAltura)
        cxHomem = findViewById<RadioButton>(R.id.checkboxHomem)
        cxMulher = findViewById<RadioButton>(R.id.checkboxMulher)
        calcImc = findViewById(R.id.button)


        calcImc.setOnClickListener{
            var mensagem = " "
            val alt = altura.text.toString().toDouble()
            var imcH = (72.7 *alt) - 58;
            var imcM =(62.1  *alt) - 44.7;
            if (cxHomem.isChecked){
                mensagem = "O peso ideal é ${imcH}"
                Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
            }else if (cxMulher.isChecked){
                mensagem = "O peso ideal é ${imcM}"
                Toast.makeText(this,mensagem,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Defina o sexo", Toast.LENGTH_LONG).show()
            }
        }

    }
}
