package com.example.everytime_clone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.everytime_clone.databinding.FragmentCheattingBinding
import com.example.everytime_clone.databinding.FragmentHomeBinding

class CheattingFragment : Fragment() {

    private lateinit var binding: FragmentCheattingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheattingBinding.inflate(inflater)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}