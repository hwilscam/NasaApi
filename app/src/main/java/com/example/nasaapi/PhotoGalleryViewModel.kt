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


class PhotoGalleryViewModel :ViewModel() {

    private val photoRepository = PhotoRepository()


    private val _galleryItems: MutableStateFlow<List<GalleryItem>> = MutableStateFlow(emptyList())
    val galleryItems: StateFlow<List<GalleryItem>>
        get() = _galleryItems.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val items = getPhotos(
                    apiKey = "H4FxG4aJIHrxBHcUuFEVdXE3rdxDKCycrSCc1e5h",
                    image_amount = 75
                )
                _galleryItems.value = items
            } catch (ex: Exception) {
                Log.e("PhotoGalleryViewModel", "Failed to fetch random gallery items", ex)
            }
        }
    }
    suspend fun getPhotos(apiKey: String,image_amount: Int) =
        photoRepository.fetchPhotos(apiKey, image_amount = image_amount)
}