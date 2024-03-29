package com.yoshikawa.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.yoshikawa.orgs.R
import com.yoshikawa.orgs.dao.ProdutosDao
import com.yoshikawa.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configBotaoSalvar()

    }

    private fun configBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.formulario_botao_salvar)
        botaoSalvar.setOnClickListener {
            val inputname = findViewById<EditText>(R.id.produto_item_nome)
            val inputDescrition = findViewById<EditText>(R.id.produto_item_descricao)
            val inputValue = findViewById<EditText>(R.id.produto_item_valor)
            val name = inputname.text.toString()
            val descrition = inputDescrition.text.toString()
            val valueInText = inputValue.text.toString()
            val value = if (valueInText.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valueInText)
            }
            val questao = findViewById<TextView>(R.id.questao1)
            val questaoUm = questao.text.toString()
            val newProduct = Produto(
                nome = name,
                descricao = descrition,
                questaoUm = questaoUm,
                valor = value

            )

            Log.i("Lista", "nome: $name , $descrition , $value")
            val dao = ProdutosDao()
            dao.adicione(newProduct)
            Log.i("Lista de produtos", "itens: ${dao.buscarTodos()}")
            finish()
        }
    }
}