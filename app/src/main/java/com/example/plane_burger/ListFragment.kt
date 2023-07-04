package com.example.plane_burger

import PhotoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plane_burger.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var binding: FragmentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.root?.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = PhotoAdapter()
        adapter.photos = mutableListOf(
            Photo(R.drawable.boeing_747, R.string.boeing_747, R.string._1970),
            Photo(R.drawable.boeing_747, R.string.boeing_747, R.string._1970),
            Photo(R.drawable.boeing_747, R.string.boeing_747, R.string._1970),
            Photo(R.drawable.boeing_747, R.string.boeing_747, R.string._1970)
        )

        binding?.root?.adapter = adapter
    }
}