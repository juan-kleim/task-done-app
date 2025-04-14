package com.juanpacheco.apptaskdone.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.juanpacheco.apptaskdone.R
import com.juanpacheco.apptaskdone.adapter.TarefaAdapter
import com.juanpacheco.apptaskdone.database.TarefaDAO
import com.juanpacheco.apptaskdone.databinding.FragmentHomeBinding
import com.juanpacheco.apptaskdone.model.Tarefa

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var listaTarefas = emptyList<Tarefa>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMinhasTarefas.setOnClickListener {
            findNavController().navigate(R.id.tasksFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val navController = Navigation.findNavController(view)
                    navController.navigateUp()
                }
            })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}