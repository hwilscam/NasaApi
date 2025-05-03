package com.example.nasaapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.nasaapi.api.GalleryItem
import com.example.nasaapi.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(galleryItem: GalleryItem) {
        binding.itemImageView.load(galleryItem.url)
        binding.root.setOnClickListener {
            val action = PhotoGalleryFragmentDirections
                .actionPhotoGalleryFragmentToSinglePhotoFragment(galleryItem.url, galleryItem.title)
            binding.root.findNavController().navigate(action)
        }
    }
}

class PhotoListAdapter(
    private val galleryItems: List<GalleryItem>,
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(galleryItems[position])
    }

    override fun getItemCount() = galleryItems.size
}