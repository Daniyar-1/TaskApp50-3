package com.dm.taskapp.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.dm.taskapp.R
import com.dm.taskapp.databinding.FragmentOnBoardPageBinding
import com.dm.taskapp.databinding.FragmentOnBoardingBinding
import com.dm.taskapp.ui.onBoard.adapter.ViewPagerAdapter

class OnBoardPageFragment(
    var listenerSkip: () -> Unit,
    var listenerNext: () -> Unit
) : Fragment() {

    private lateinit var binding: FragmentOnBoardPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initViews() {
        arguments?.let {
            val data = it.getSerializable("onBoard") as OnBoard
            binding.tvTitleBoard.text = data.title
            binding.tvDescBoard.text = data.desc
            data.img?.let { it1 -> binding.imgBoard.setImageResource(it1) }
            binding.btnSkipBoard.isVisible = data.isLast == false
            binding.btnNextBoard.isVisible = data.isLast == false
            binding.btnStartBoard.isVisible = data.isLast == true
        }
    }

    private fun initListeners() {
        binding.btnNextBoard.setOnClickListener {
            listenerNext.invoke()
        }
        binding.btnSkipBoard.setOnClickListener {
            listenerSkip.invoke()
        }
        binding.btnStartBoard.setOnClickListener {
            findNavController().navigate(R.id.navigation_home)
        }
    }
}