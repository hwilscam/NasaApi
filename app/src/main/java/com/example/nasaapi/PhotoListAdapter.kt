package com.example.nasaapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.nasaapi.api.GalleryItem
import com.example.nasaapi.api.NasaResponse
import com.example.nasaapi.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(galleryItem: GalleryItem) {
        // Load the image into the image view
        binding.itemImageView.load(galleryItem.url)

        // Set the click listener to navigate to the single photo fragment
        binding.root.setOnClickListener {
            val action = PhotoGalleryFragmentDirections
                .actionPhotoGalleryFragmentToSinglePhotoFragment(galleryItem.url, galleryItem.title)
            itemView.findNavController().navigate(action)
        }
    }
}

/*class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
): RecyclerView.ViewHolder(binding.root){
    fun bind(galleryItem: GalleryItem){
        binding.itemImageView.load(galleryItem.url)
    }
}*/


class PhotoListAdapter(
    private val galleryItem: List<GalleryItem>,
) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItem[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
        }
    }



    override fun getItemCount() = galleryItem.size
}