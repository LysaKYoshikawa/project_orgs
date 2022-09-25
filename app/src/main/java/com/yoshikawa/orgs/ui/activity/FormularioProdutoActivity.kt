package com.yoshikawa.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.yoshikawa.orgs.R
import com.yoshikawa.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.button_salvar)
        botaoSalvar.setOnClickListener {
            val inputname = findViewById<EditText>(R.id.nome)
            val inputDescrition = findViewById<EditText>(R.id.descricao)
            val inputValue = findViewById<EditText>(R.id.valor)
            val name = inputname.text.toString()
            val descrition = inputDescrition.text.toString()
            val valueInText = inputValue.text.toString()
            val value = if(valueInText.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(valueInText)
            }
            val newProduct = Produto(
                nome = name,
                descricao = descrition,
                valor = value
            )

            Log.i("F", "nome: $name , $descrition , $value")
            Log.i("F", "nome: $newProduct")
        }


    }
}