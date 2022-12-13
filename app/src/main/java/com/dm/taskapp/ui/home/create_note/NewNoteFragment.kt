package com.dm.taskapp.ui.home.create_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.dm.taskapp.databinding.FragmentNewNoteBinding
import com.dm.taskapp.ui.home.Task

class NewNoteFragment : Fragment() {

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)

        initViews()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {
            setFragmentResult(
                "new_note", bundleOf(
                    "task" to Task(
                        binding.etTitle.text.toString(),
                        binding.etDesc.text.toString())
                )
            )
            findNavController().navigateUp()
        }
    }

    private fun initViews() {

    }
    override fun onDestroy() {
        super.onDestroy()
        findNavController().navigateUp()
    }
}