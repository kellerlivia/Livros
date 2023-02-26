package br.com.app.livros.dao

import br.com.app.livros.model.Livro

class LivrosDao {

    fun adiciona(livro: Livro) {
        livros.add(livro)
    }

    fun buscaTodos() : List<Livro> {
        return livros.toList()
    }

    companion object {
        private val livros = mutableListOf<Livro>()
    }
}