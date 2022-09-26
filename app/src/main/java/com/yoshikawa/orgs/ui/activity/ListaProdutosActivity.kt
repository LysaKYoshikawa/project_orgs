package com.yoshikawa.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yoshikawa.orgs.R
import com.yoshikawa.orgs.dao.ProdutosDao
import com.yoshikawa.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutosDao()
    private val adapter =  ListaProdutosAdapter(context = this, produtos = dao.buscarTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configureFab()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscarTodos())

    }

    private fun configureFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            levandoParaFormulario()
        }
    }

    private fun levandoParaFormulario() {
        var intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_RecyclerView)

        Log.i("Na main", "fun oncreate: ${dao.buscarTodos()}")
        recyclerView.adapter = adapter
    }
}