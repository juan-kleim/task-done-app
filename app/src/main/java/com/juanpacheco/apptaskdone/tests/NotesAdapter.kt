package com.juanpacheco.apptaskdone.tests

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.juanpacheco.apptaskdone.R

class NotesAdapter(

    private val lista: List<Note>
): Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(
        val itemView: View
    ): ViewHolder( itemView ){

        val textTitulo: TextView = itemView.findViewById(R.id.text_titulo)
        val textDescricao: TextView = itemView.findViewById(R.id.text_descricao)
        val textData: TextView = itemView.findViewById(R.id.text_data)

    }

    //Ao criar o ViewHolder - criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )
        val itemView = layoutInflater.inflate(
            R.layout.item_lista, parent, false
        )
        return NotesViewHolder( itemView )

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        val notes = lista[position]
        holder.textTitulo.text = notes.titulo
        holder.textDescricao.text = notes.descricao
        holder.textData.text = notes.data

    }

    //Recuperar a quantidade de itens
    override fun getItemCount(): Int {

        return lista.size

    }

}