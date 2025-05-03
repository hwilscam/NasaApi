package com.example.nasaapi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaapi.api.GalleryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "PhotoGalleryViewModel"

class PhotoGalleryViewModel : ViewModel() {

    private val photoRepository = PhotoRepository()

    private val _galleryItems: MutableStateFlow<List<GalleryItem>> =
        MutableStateFlow(emptyList())
    val galleryItem: StateFlow<List<GalleryItem>>
        get() = _galleryItems.asStateFlow()

    init {
        viewModelScope.launch {

            try {
                val items = photoRepository.fetchPhotos()
                Log.d(TAG, "Items Received : $items")
                _galleryItems.value = items
            }catch (ex:Exception){

                Log.e(TAG, "Failed to fetch gallery items", ex)
            }
        }
    }
}