package com.yoshikawa.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yoshikawa.orgs.R
import com.yoshikawa.orgs.dao.ProdutosDao
import com.yoshikawa.orgs.model.Produto
import com.yoshikawa.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity(R.layout.activity_main) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProdutosDao()
        Log.i("Na main", "fun oncreate: ${dao.buscarTodos()}")
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscarTodos() )
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            var intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }

    }
}