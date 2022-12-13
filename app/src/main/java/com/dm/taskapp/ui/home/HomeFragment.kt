package com.dm.taskapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dm.taskapp.R
import com.dm.taskapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()
        initListeners()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()

    }

    private fun initListeners() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.newNoteFragment)
        }
    }

    private fun initViews() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HomeFragment.adapter
        }
        setFragmentResultListener("new_note") { key, bundle ->
            Log.e(
                "ololo",
                "Answer new note ${bundle.getString("title")} ${bundle.getString("desc")} "
            )
            val task = bundle.getSerializable("task") as Task
            adapter.addTask(task)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}