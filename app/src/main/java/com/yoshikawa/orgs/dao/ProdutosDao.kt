package com.yoshikawa.orgs.dao

import com.yoshikawa.orgs.model.Produto

class ProdutosDao {

    private val produtos = mutableListOf<Produto>()

    fun adicione(produto: Produto){
        produtos.add(produto)

    }

    fun buscarTodos() : List<Produto> {
        return produtos.toList()

    }

}