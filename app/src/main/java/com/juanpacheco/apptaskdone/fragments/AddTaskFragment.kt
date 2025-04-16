package com.juanpacheco.apptaskdone.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.juanpacheco.apptaskdone.database.TarefaDAO
import com.juanpacheco.apptaskdone.databinding.FragmentAddTaskBinding
import com.juanpacheco.apptaskdone.model.Tarefa

/**
 * A simple [Fragment] subclass.
 * Use the [AddTaskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class AddTaskFragment : Fragment() {
    private var _binding: FragmentAddTaskBinding? = null
    private val binding get() = _binding!!

//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

//        arguments?.let {
//            param1 = it.getString()
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        val binding = _binding!!

        val tarefaRecebida: Tarefa? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("tarefa", Tarefa::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getSerializable("tarefa") as? Tarefa
        }

        tarefaRecebida?.let { tarefa ->
            binding.editTarefaTasks.setText(tarefa.descricao)
        }

        binding.btnSalvarAddTasks.setOnClickListener {
            val descricao = binding.editTarefaTasks.text.toString()

            if (descricao.isNotEmpty()) {
                val tarefaDAO = TarefaDAO(requireContext())

                if (tarefaRecebida != null) {
                    val tarefaAtualizada = tarefaRecebida.copy(descricao = descricao)
                    tarefaDAO.atualizar(tarefaAtualizada)
                    Toast.makeText(requireContext(), "Tarefa atualizada com sucesso", Toast.LENGTH_SHORT).show()
                } else {
                    val novaTarefa = Tarefa(-1, descricao, "default")
                    tarefaDAO.salvar(novaTarefa)
                    Toast.makeText(requireContext(), "Tarefa adicionada com sucesso", Toast.LENGTH_SHORT).show()
                }

                findNavController().popBackStack()

            } else {
                Toast.makeText(requireContext(), "Preencha uma tarefa", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment AddTaskFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            AddTaskFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}