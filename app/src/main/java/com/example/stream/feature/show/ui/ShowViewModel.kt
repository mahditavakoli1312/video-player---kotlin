package com.example.stream.feature.show.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.example.stream.feature.show.data.repository.ShowRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ShowViewModel @Inject constructor(
    showRepository: ShowRepository
) : ViewModel() {
    private val _videoDetails = showRepository.getVideoDetail().map {
        it.toVideoDetailsView()
    }
    val  videoDetails : Flow<VideoDetailsView> = _videoDetails
}