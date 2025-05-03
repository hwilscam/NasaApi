package com.example.nasaapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.nasaapi.databinding.FragmentPhotoSingleBinding

class SinglePhotoFragment : Fragment() {

    private var _binding: FragmentPhotoSingleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoSingleBinding.inflate(inflater, container, false)

        val imageUrl = arguments?.getString("imageUrl") ?: ""
        val title = arguments?.getString("title") ?: ""

        binding.imageView.load(imageUrl)
        binding.titleTextView.text = title

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}