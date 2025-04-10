package com.juanpacheco.apptaskdone.database

import android.content.Context
import com.juanpacheco.apptaskdone.model.Tarefa

class TarefaDAO(context: Context) : ITarefaDAO {

    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(tarefa: Tarefa): Boolean {

        try {
        }catch (e: Exception){
            return false
        }
        return true
    }

    override fun atualizar(tarefa: Tarefa): Boolean {
        try {
        }catch (e: Exception){
            return false
        }
        return true
    }

    override fun deletar(id: Int): Boolean {
        try {
        }catch (e: Exception){
            return false
        }
        return true
    }

    override fun listar(): List<Tarefa> {
        val listaTarefas = mutableListOf<Tarefa>()
        return listaTarefas
    }

}