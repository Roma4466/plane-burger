package com.example.plane_burger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.plane_burger.databinding.FragmentListBinding
import com.example.plane_burger.databinding.FragmentPlaneBinding

class PlaneFragment : Fragment() {
    private var binding: FragmentPlaneBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaneBinding.inflate(inflater, container, false)
        return binding?.root
    }
}