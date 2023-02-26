package br.com.app.livros.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import br.com.app.livros.R
import br.com.app.livros.dao.LivrosDao
import br.com.app.livros.model.Livro
import java.math.BigDecimal

class FormularioLivroActivity :
    AppCompatActivity(R.layout.activity_formulario_livro) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_livro_botao_salvar)
        val dao = LivrosDao()
        botaoSalvar.setOnClickListener {
            val livroNovo = criaLivro()
            dao.adiciona(livroNovo)
            finish()
        }
    }

    private fun criaLivro(): Livro {
        val campoTitulo = findViewById<EditText>(R.id.activity_formulario_livro_titulo)
        val titulo = campoTitulo.text.toString()
        val campoAutor = findViewById<EditText>(R.id.activity_formulario_livro_autor)
        val autor = campoAutor.text.toString()
        val campoPreco = findViewById<EditText>(R.id.activity_formulario_livro_preco)
        val precoEmTexto = campoPreco.text.toString()

        val preco = if (precoEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(precoEmTexto)
        }

        return Livro(
            titulo = titulo,
            autor = autor,
            preco = preco
        )
    }
}