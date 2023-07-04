package com.example.plane_burger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.example.plane_burger.databinding.FragmentPlaneBinding

private const val TEXT = "text"
private const val TITLE = "title"
private const val TITLE_DESCRIPTION = "title DESCRIPTION"
private const val PHOTO = "photo"

class PlaneFragment : Fragment() {
    private var binding: FragmentPlaneBinding? = null

    private var textRes: String? = null
    private var imageRes: Int? = null
    private var titleRes: String? = null
    private var titleDescriptionRes: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            textRes = it.getString(TEXT)
            imageRes = it.getInt(PHOTO)
            titleRes = it.getString(TITLE)
            titleDescriptionRes = it.getString(TITLE_DESCRIPTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaneBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            titleDescriptionRes?.let {
                title.text = it
            }
            titleRes?.let {
                (requireActivity() as MainActivity).changeTitle(it)
            }
            textRes?.let { description.text = it }
            if(imageRes == null){
                image.visibility = View.GONE
            } else{
                image.setImageResource(imageRes!!)
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        (requireActivity() as MainActivity).setDefaultTitle()
    }

    companion object {
        @JvmStatic
        fun newInstance(stringRes: String, titleDescriptionRes: String, photoRes: Int?, titleRes: String) =
            PlaneFragment().apply {
                arguments = Bundle().apply {
                    putString(TEXT, stringRes)
                    putString(TITLE, titleRes)
                    putString(TITLE_DESCRIPTION, titleDescriptionRes)
                    if (photoRes != null) {
                        putInt(PHOTO, photoRes)
                    }
                }
            }
    }
}