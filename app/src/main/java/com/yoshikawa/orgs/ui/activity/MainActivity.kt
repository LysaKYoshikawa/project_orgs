package com.yoshikawa.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yoshikawa.orgs.R
import com.yoshikawa.orgs.model.Produto
import com.yoshikawa.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val nome = findViewById<TextView>(R.id.nome)
//        nome.text = "Cesta de Frutas"
//        val descricao = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Maça, Laranja e uva"
//        val valor = findViewById<TextView>(R.id.valor)
//        valor.text = "19.99"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(nome = "Frutas",
                    descricao = "Uva",
                    valor = BigDecimal("20.00")
            ),
            Produto(nome = "Frutas",
                    descricao = "Laranja",
                    valor = BigDecimal("15.60")
            )
        ))
        //recyclerView.layoutManager = LinearLayoutManager(this)
    }
}