package com.example.aulalodjinha.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aulalodjinha.databinding.FragmentFailBinding


class FailFragment : Fragment() {

    private var _binding: FragmentFailBinding? = null
    private val binding: FragmentFailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFailBinding.inflate(inflater)
        return binding.root
    }
}