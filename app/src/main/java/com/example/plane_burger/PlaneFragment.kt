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
private const val PHOTO = "photo"

class PlaneFragment : Fragment() {
    private var binding: FragmentPlaneBinding? = null

    private var textRes: Int? = null
    private var imageRes: Int? = null
    private var titleRes: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            textRes = it.getInt(TEXT)
            imageRes = it.getInt(PHOTO)
            titleRes = it.getInt(TITLE)
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
            titleRes?.let { title.setText(it) }
            textRes?.let { description.setText(it) }
            if(imageRes == null){
                image.visibility = View.GONE
            } else{
                image.setImageResource(imageRes!!)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(@StringRes stringRes: Int, @StringRes titleRes: Int, photoRes: Int?) =
            PlaneFragment().apply {
                arguments = Bundle().apply {
                    putInt(TEXT, stringRes)
                    putInt(TITLE, titleRes)
                    if (photoRes != null) {
                        putInt(PHOTO, photoRes)
                    }
                }
            }
    }
}