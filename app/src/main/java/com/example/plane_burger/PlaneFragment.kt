package com.example.plane_burger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.example.plane_burger.databinding.FragmentPlaneBinding

private const val POSITION = "photo"

class PlaneFragment : Fragment() {
    private var binding: FragmentPlaneBinding? = null

    private var position: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(POSITION)
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
            position?.let {
                title.text = getPhotoFromPosition(resources, it).titleDescription
            }
            position?.let {
                (requireActivity() as MainActivity).changeTitle(
                    getPhotoFromPosition(
                        resources,
                        it
                    ).title
                )
            }
            position?.let { description.text = getPhotoFromPosition(resources, it).description }
            position?.let {
                try {
                    image.setImageResource(getPhotoFromPosition(resources, it).imageRes)
                } catch (e: Throwable){
                    image.visibility = View.GONE
                }

            }

        }
    }

    override fun onDetach() {
        super.onDetach()
        (requireActivity() as MainActivity).setDefaultTitle()
    }

    companion object {
        @JvmStatic
        fun newInstance(i: Int) =
            PlaneFragment().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, i)
                }
            }
    }
}