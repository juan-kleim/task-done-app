package com.juanpacheco.apptaskdone.model

import java.io.Serializable

data class Tarefa(
    val idTarefa: Int,
    val descricao: String,
    val dataCadastro: String
): Serializable