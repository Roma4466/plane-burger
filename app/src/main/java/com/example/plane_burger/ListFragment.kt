package com.example.plane_burger

import PhotoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plane_burger.databinding.FragmentListBinding

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
        val adapter = PhotoAdapter(this)
        adapter.photos = mutableListOf(
            Photo(
                imageRes = R.drawable.boeing_747,
                title = R.string.boeing_747,
                year = R.string._1970,
                titleDescription = R.string.plane_description_title,
                description = R.string.plane_description,
                photoDescription = R.drawable.photo_2023_07_04_19_39_01
            ),
            Photo(
                imageRes = R.drawable.boeing_747,
                title = R.string.boeing_747,
                year = R.string._1970,
                titleDescription = R.string.plane_description_title,
                description = R.string.plane_description,
                photoDescription = R.drawable.photo_2023_07_04_19_39_01
            ),
            Photo(
                imageRes = R.drawable.boeing_747,
                title = R.string.boeing_747,
                year = R.string._1970,
                titleDescription = R.string.plane_description_title,
                description = R.string.plane_description,
                photoDescription = R.drawable.photo_2023_07_04_19_39_01
            ),
            Photo(
                imageRes = R.drawable.boeing_747,
                title = R.string.boeing_747,
                year = R.string._1970,
                titleDescription = R.string.plane_description_title,
                description = R.string.plane_description,
                photoDescription = R.drawable.photo_2023_07_04_19_39_01
            ),
        )

        binding?.root?.adapter = adapter
    }

    override fun onItemClick(view: View, element: Photo) {
        val fragment = PlaneFragment.newInstance(
            stringRes = element.description,
            titleRes = element.title,
            photoRes = element.photoDescription,
            titleDescriptionRes = element.titleDescription
        )

        parentFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .setTransition(TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(null).commit()
    }
}