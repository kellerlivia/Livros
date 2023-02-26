package br.com.app.livros.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.app.livros.R
import br.com.app.livros.model.Livro

class ListaLivrosAdapter(
    private val context: Context,
    livros: List<Livro>
) : RecyclerView.Adapter<ListaLivrosAdapter.ViewHolder>() {

    private val livros = livros.toMutableList()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun vincula(livro: Livro) {
            val titulo = itemView.findViewById<TextView>(R.id.livro_item_titulo)
            titulo.text = livro.titulo
            val autor = itemView.findViewById<TextView>(R.id.livro_item_autor)
            autor.text = livro.autor
            val preco = itemView.findViewById<TextView>(R.id.livro_item_preco)
            preco.text = livro.preco.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.livro_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = livros.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val livro = livros[position]
        holder.vincula(livro)
    }

    fun atualiza(livros: List<Livro>) {
        this.livros.clear()
        this.livros.addAll(livros)
        notifyDataSetChanged()
    }

}
