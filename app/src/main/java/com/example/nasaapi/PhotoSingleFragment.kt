package com.example.nasaapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nasaapi.api.NasaResponse
import coil.load
import com.example.nasaapi.databinding.FragmentPhotoSingleBinding

class SinglePhotoFragment : Fragment() {

    private var _binding: FragmentPhotoSingleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoSingleBinding.inflate(inflater, container, false)

        // Get the arguments passed to the fragment
        val imageUrl = arguments?.getString("imageUrl") ?: ""
        val title = arguments?.getString("title") ?: ""

        // Set the image and title
        binding.imageView.load(imageUrl)
        binding.titleTextView.text = title

        // Center the image both horizontally and vertically
        binding.imageView.layoutParams = (binding.imageView.layoutParams as ViewGroup.MarginLayoutParams).apply {
            topMargin = 0 // Optional: Adjust top margin if needed
            leftMargin = 0 // Optional: Adjust left margin if needed
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/*
class SinglePhotoFragment : Fragment() {

    private var _binding: FragmentPhotoSingleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoSingleBinding.inflate(inflater, container, false)

        val selectedPhoto = arguments?.<NasaResponse>("selected_photo")

        selectedPhoto?.let {
            binding.photoImageView.load(it.url)
            binding.photoTitle.text = it.title
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}*/
