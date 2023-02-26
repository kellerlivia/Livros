package br.com.app.livros.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.app.livros.R
import br.com.app.livros.dao.LivrosDao
import br.com.app.livros.ui.recyclerview.adapter.ListaLivrosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaLivrosActivity : AppCompatActivity(R.layout.activity_lista_livros) {

    private val dao = LivrosDao()
    private val adapter = ListaLivrosAdapter(context = this, dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_livros_floatingActionButton)
        fab.setOnClickListener {
            vaiParaFormularioLivro()
        }
    }

    private fun vaiParaFormularioLivro() {
        val intent = Intent(this, FormularioLivroActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_livros_recyclerView)
        recyclerView.adapter = adapter
    }
}