package com.example.stream.feature.show.data.datasource.local

import com.example.stream.feature.show.data.model.entity.VideoDetailsEntity
import kotlinx.coroutines.flow.Flow

interface ShowLocalDataSource {
    fun getVideoDetail() : Flow<VideoDetailsEntity>
}