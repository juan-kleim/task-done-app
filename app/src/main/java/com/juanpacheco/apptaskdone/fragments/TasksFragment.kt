package com.juanpacheco.apptaskdone.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanpacheco.apptaskdone.R
import com.juanpacheco.apptaskdone.adapter.TarefaAdapter
import com.juanpacheco.apptaskdone.database.TarefaDAO
import com.juanpacheco.apptaskdone.databinding.FragmentHomeBinding
import com.juanpacheco.apptaskdone.databinding.FragmentTasksBinding
import com.juanpacheco.apptaskdone.model.Tarefa

class TasksFragment : Fragment() {

    var listaTarefas = listOf(
        Tarefa(1, "123", "23/11/2002")
    )

    private var tarefaAdapter: TarefaAdapter? = null
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabAdicionar.setOnClickListener {
            findNavController().navigate(R.id.addTaskFragment)
        }

        //RecyclerView
        tarefaAdapter = TarefaAdapter()
        binding.rvTarefas.adapter = tarefaAdapter

        binding.rvTarefas.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun atualizarListaTarefas() {
        val tarefaDAO = TarefaDAO(requireContext())
        listaTarefas = tarefaDAO.listar()
        tarefaAdapter?.adicionarLista(listaTarefas)
    }

    override fun onStart() {
        super.onStart()
        atualizarListaTarefas()

        }
    }