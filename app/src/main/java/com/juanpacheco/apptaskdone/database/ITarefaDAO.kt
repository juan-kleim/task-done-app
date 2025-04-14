package com.juanpacheco.apptaskdone.database

import com.juanpacheco.apptaskdone.model.Tarefa

interface ITarefaDAO {

    fun salvar( tarefa: Tarefa ): Boolean
    fun atualizar( tarefa: Tarefa ): Boolean
    fun remover( idTarefa: Int ): Boolean
    fun listar(): List<Tarefa>

}