package com.juanpacheco.apptaskdone.tests

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juanpacheco.apptaskdone.R

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvLista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        val lista = listOf<Note>(

            Note("Séries", "Séries que quero assistir", "22 Feb"),
            Note("Compras", "Compras que preciso fazer", "22 Feb"),
            Note("Anotações", "Anotações pessoais", "22 Feb"),

        )

        rvLista = findViewById(R.id.rv_lista)
        rvLista.adapter = NotesAdapter( lista ) //Tipo: MensagemAdapter, Adapter
        rvLista.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}