package com.example.plane_burger

import PhotoAdapter
import android.content.res.Resources
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
        val adapter = PhotoAdapter(this)

        adapter.photos = parseDataFromXml(resources)

        binding?.root?.adapter = adapter
    }

    private fun parseDataFromXml(resources: Resources): MutableList<Photo> {
        val iconsArray = resources.obtainTypedArray(R.array.icons)
        val descriptionImagesArray = resources.obtainTypedArray(R.array.descriptionImages)
        val titlesArray = resources.getStringArray(R.array.titles)
        val descriptionTitlesArray = resources.getStringArray(R.array.descriptionTitles)
        val descriptionsArray = resources.getStringArray(R.array.descriptions)
        val yearsArray = resources.getIntArray(R.array.years)

        val photoList = mutableListOf<Photo>()

        for (i in 0 until iconsArray.length()) {
            val photo = Photo(
                imageRes = iconsArray.getResourceId(i, 0),
                title = titlesArray[i],
                year = yearsArray[i].toString(),
                titleDescription = descriptionTitlesArray[i],
                description = descriptionsArray[i],
                photoDescription = descriptionImagesArray.getResourceId(i, 0)
            )
            photoList.add(photo)
        }

        iconsArray.recycle()
        descriptionImagesArray.recycle()

        return photoList
    }


    override fun onItemClick(itemBinding: PictureWithTextBinding, element: Photo) {
        itemBinding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))

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