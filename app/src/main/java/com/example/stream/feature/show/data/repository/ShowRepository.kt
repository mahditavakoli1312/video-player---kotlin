package com.example.stream.feature.show.data.repository

import com.example.stream.feature.show.data.model.entity.VideoDetailsEntity
import kotlinx.coroutines.flow.Flow

interface ShowRepository {
    fun getVideoDetail() : Flow<VideoDetailsEntity>
}