package com.example.plane_burger

import PhotoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plane_burger.databinding.FragmentListBinding
import com.example.plane_burger.databinding.PictureWithTextBinding

class ListFragment : Fragment(), PhotoAdapter.OnItemClickListener {
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
        val adapter = PhotoAdapter(resources, this)

        adapter.photoPostions = mutableListOf(0, 1, 2, 3)

        binding?.root?.adapter = adapter
    }

    override fun onItemClick(itemBinding: PictureWithTextBinding, element: Int) {
        itemBinding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))

        val fragment = PlaneFragment.newInstance(element)

        parentFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .setTransition(TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(null).commit()
    }
}