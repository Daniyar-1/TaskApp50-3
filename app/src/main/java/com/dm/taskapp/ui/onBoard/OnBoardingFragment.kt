package com.dm.taskapp.ui.onBoard

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dm.taskapp.R
import com.dm.taskapp.databinding.FragmentOnBoardingBinding
import com.dm.taskapp.ui.onBoard.adapter.ViewPagerAdapter


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter(childFragmentManager, this::onSkipClick, this::onNextClick)
        binding.vpOnboard.adapter = adapter
        binding.springDotsIndicator.attachTo(binding.vpOnboard)
    }

    private fun onSkipClick() {
        binding.vpOnboard.currentItem = 2
    }

    private fun onNextClick() {
        binding.vpOnboard.currentItem += 1
    }
}